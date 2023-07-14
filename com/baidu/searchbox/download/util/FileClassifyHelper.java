package com.baidu.searchbox.download.util;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.android.util.io.FileUtils;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.ioc.DownloadRuntime;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.fun.ad.sdk.FunAdSdk;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.MimeTypes;
import com.kuaishou.weapon.p0.u;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public final class FileClassifyHelper {
    public static final Pattern CONTENT_DISPOSITION_PATTERN;
    public static final int DOWNLOADED_TYPE_ANY = -2;
    public static final int DOWNLOADED_TYPE_APP = 3;
    public static final int DOWNLOADED_TYPE_DIR = 7;
    public static final int DOWNLOADED_TYPE_DOC = 4;
    public static final int DOWNLOADED_TYPE_DOWNLOADED = 13;
    public static final int DOWNLOADED_TYPE_DOWNLOADING = 12;
    public static final int DOWNLOADED_TYPE_FILE_VIEWER = 10;
    public static final int DOWNLOADED_TYPE_FOLD = 9;
    public static final int DOWNLOADED_TYPE_IMAGE = 2;
    public static final int DOWNLOADED_TYPE_MUSIC = 1;
    public static final int DOWNLOADED_TYPE_NONE = -1;
    public static final int DOWNLOADED_TYPE_NOVEL = 6;
    public static final int DOWNLOADED_TYPE_OFFLINE_WEB = 11;
    public static final int DOWNLOADED_TYPE_OTHERS = 5;
    public static final int DOWNLOADED_TYPE_VIDEO = 0;
    public static final int DOWNLOADED_TYPE_ZIP = 8;
    public static final String FILE_SUFFIX_DOT = ".";
    public static final String FILE_SUFFIX_JPG = ".jpg";
    public static final String IMAGE_PREFIX = "image/";
    public static final String MIME_TYPE_APK = "application/vnd.android.package-archive";
    public static final String MIME_TYPE_M3U8 = "application/vnd.apple.mpegurl";
    public static final String TAG = "FileClassifyHelper";
    public static final boolean DEBUG = DownloadRuntime.GLOBAL_DEBUG;
    public static HashMap<String, Integer> sExtTypeMap = new HashMap<>();
    public static HashMap<String, Integer> sMimeTypeMap = new HashMap<>();
    public static HashMap<String, String> sExtensionToMimeTypeMap = new HashMap<>();
    public static HashMap<String, String> sMimeTypeToExtensionMap = new HashMap<>();
    public static HashMap<String, Integer> sMimeTypeExtensionToTypeMap = new HashMap<>();
    public static HashMap<String, List<String>> mNeedReplaceMimetype = new HashMap<>();

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("png");
        arrayList.add("jpe");
        arrayList.add("jpeg");
        arrayList.add(NativeConstants.TYPE_GIF);
        arrayList.add(DownloadStatisticConstants.UBC_TYPE_MP4);
        arrayList.add("wav");
        arrayList.add("mp3");
        mNeedReplaceMimetype.put("application/octet-stream", arrayList);
        add("application/andrew-inset", "ez", 5);
        add("application/dsptype", "tsp", 5);
        add("application/futuresplash", "spl", 5);
        add("application/hta", "hta", 5);
        add("application/mac-binhex40", "hqx", 5);
        add("application/mac-compactpro", "cpt", 5);
        add("application/mathematica", BaseContentUploader.NB, 5);
        add("application/msaccess", "mdb", 5);
        add("application/oda", "oda", 5);
        add("application/ogg", "ogg", 1);
        add(DocumentOpenUtil.PDF_TYPE, "pdf", 4);
        add("application/pgp-keys", "key", 5);
        add("application/pgp-signature", "pgp", 5);
        add("application/pics-rules", "prf", 5);
        add("application/rar", "rar", 8);
        add("application/x-rar-compressed", "rar", 8);
        add("application/7z", "7z", 8);
        add("application/x-7z-compressed", "7z", 8);
        add("application/rdf+xml", "rdf", 5);
        add("application/rss+xml", "rss", 5);
        add("application/zip", "zip", 8);
        add("application/x-zip-compressed", "zip", 8);
        add("application/vnd.android.package-archive", "apk", 3);
        add("application/vnd.cinderella", "cdy", 5);
        add("application/vnd.ms-pki.stl", "stl", 5);
        add("application/vnd.oasis.opendocument.database", "odb", 5);
        add("application/vnd.oasis.opendocument.formula", "odf", 5);
        add("application/vnd.oasis.opendocument.graphics", "odg", 5);
        add("application/vnd.oasis.opendocument.graphics-template", "otg", 5);
        add("application/vnd.oasis.opendocument.image", "odi", 5);
        add("application/vnd.oasis.opendocument.spreadsheet", "ods", 5);
        add("application/vnd.oasis.opendocument.spreadsheet-template", "ots", 5);
        add("application/vnd.oasis.opendocument.text", "odt", 5);
        add("application/vnd.oasis.opendocument.text-master", "odm", 5);
        add("application/vnd.oasis.opendocument.text-template", "ott", 5);
        add("application/vnd.oasis.opendocument.text-web", "oth", 5);
        add("application/vnd.google-earth.kml+xml", "kml", 5);
        add("application/vnd.google-earth.kmz", "kmz", 5);
        add(DocumentOpenUtil.WORD_TYPE, "doc", 4);
        add(DocumentOpenUtil.WORD_TYPE, "dot", 4);
        add(DocumentOpenUtil.DOCUMENT_TYPE, DocumentOpenUtil.DOCX, 4);
        add("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", 4);
        add(DocumentOpenUtil.EXCEL_TYPE, "xls", 4);
        add(DocumentOpenUtil.EXCEL_TYPE, "xlt", 4);
        add(DocumentOpenUtil.SHEET_TYPE, DocumentOpenUtil.XLSX, 4);
        add("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", 4);
        add(DocumentOpenUtil.PPT_TYPE, "ppt", 4);
        add(DocumentOpenUtil.PPT_TYPE, "pot", 4);
        add(DocumentOpenUtil.PPT_TYPE, "pps", 4);
        add(DocumentOpenUtil.PRESENT_TYPE, DocumentOpenUtil.PPTX, 4);
        add("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", 4);
        add("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", 4);
        add("application/vnd.rim.cod", "cod", 5);
        add("application/vnd.smaf", "mmf", 5);
        add("application/vnd.stardivision.calc", "sdc", 5);
        add("application/vnd.stardivision.draw", "sda", 5);
        add("application/vnd.stardivision.impress", "sdd", 5);
        add("application/vnd.stardivision.impress", "sdp", 5);
        add("application/vnd.stardivision.math", "smf", 5);
        add("application/vnd.stardivision.writer", "sdw", 5);
        add("application/vnd.stardivision.writer", "vor", 5);
        add("application/vnd.stardivision.writer-global", "sgl", 5);
        add("application/vnd.sun.xml.calc", "sxc", 5);
        add("application/vnd.sun.xml.calc.template", "stc", 5);
        add("application/vnd.sun.xml.draw", "sxd", 5);
        add("application/vnd.sun.xml.draw.template", "std", 5);
        add("application/vnd.sun.xml.impress", "sxi", 5);
        add("application/vnd.sun.xml.impress.template", "sti", 5);
        add("application/vnd.sun.xml.math", "sxm", 5);
        add("application/vnd.sun.xml.writer", "sxw", 5);
        add("application/vnd.sun.xml.writer.global", "sxg", 5);
        add("application/vnd.sun.xml.writer.template", "stw", 5);
        add("application/vnd.visio", "vsd", 5);
        add("application/x-abiword", "abw", 5);
        add("application/x-apple-diskimage", "dmg", 5);
        add("application/x-bcpio", "bcpio", 5);
        add("application/x-bittorrent", "torrent", 5);
        add("application/x-cdf", "cdf", 5);
        add("application/x-cdlink", "vcd", 5);
        add("application/x-chess-pgn", "pgn", 5);
        add("application/x-cpio", "cpio", 5);
        add("application/x-debian-package", "deb", 5);
        add("application/x-debian-package", "udeb", 5);
        add("application/x-director", "dcr", 5);
        add("application/x-director", MapBundleKey.MapObjKey.OBJ_DIR, 5);
        add("application/x-director", "dxr", 5);
        add("application/x-dms", "dms", 5);
        add("application/x-doom", "wad", 5);
        add("application/x-dvi", "dvi", 5);
        add("application/x-flac", "flac", 1);
        add("application/x-font", "pfa", 5);
        add("application/x-font", "pfb", 5);
        add("application/x-font", "gsf", 5);
        add("application/x-font", "pcf", 5);
        add("application/x-font", "pcf.Z", 5);
        add("application/x-freemind", FunAdSdk.PLATFORM_MM, 5);
        add("application/x-futuresplash", "spl", 5);
        add("application/x-gnumeric", "gnumeric", 5);
        add("application/x-go-sgf", "sgf", 5);
        add("application/x-graphing-calculator", "gcf", 5);
        add("application/x-gtar", "gtar", 5);
        add("application/x-gtar", "tgz", 5);
        add("application/x-gtar", "taz", 5);
        add("application/x-hdf", "hdf", 5);
        add("application/x-ica", "ica", 5);
        add("application/x-internet-signup", "ins", 5);
        add("application/x-internet-signup", "isp", 5);
        add("application/x-iphone", "iii", 5);
        add("application/x-iso9660-image", "iso", 5);
        add("application/x-jmol", "jmz", 5);
        add("application/x-kchart", "chrt", 5);
        add("application/x-killustrator", "kil", 5);
        add("application/x-koan", "skp", 5);
        add("application/x-koan", "skd", 5);
        add("application/x-koan", "skt", 5);
        add("application/x-koan", "skm", 5);
        add("application/x-kpresenter", "kpr", 5);
        add("application/x-kpresenter", "kpt", 5);
        add("application/x-kspread", "ksp", 5);
        add("application/x-kword", "kwd", 5);
        add("application/x-kword", "kwt", 5);
        add("application/x-latex", "latex", 5);
        add("application/x-lha", "lha", 5);
        add("application/x-lzh", "lzh", 5);
        add("application/x-lzx", "lzx", 5);
        add("application/x-maker", "frm", 5);
        add("application/x-maker", "maker", 5);
        add("application/x-maker", "frame", 5);
        add("application/x-maker", "fb", 5);
        add("application/x-maker", "book", 5);
        add("application/x-maker", "fbdoc", 5);
        add("application/x-mif", "mif", 5);
        add("application/x-ms-wmd", "wmd", 5);
        add("application/x-ms-wmz", "wmz", 5);
        add("application/x-msi", "msi", 5);
        add("application/x-ns-proxy-autoconfig", "pac", 5);
        add("application/x-nwc", "nwc", 5);
        add("application/x-object", "o", 5);
        add("application/x-oz-application", "oza", 5);
        add("application/x-pkcs12", "p12", 5);
        add("application/x-pkcs12", "pfx", 5);
        add("application/x-pkcs7-certreqresp", "p7r", 5);
        add("application/x-pkcs7-crl", "crl", 5);
        add("application/x-quicktimeplayer", "qtl", 5);
        add("application/x-shar", "shar", 5);
        add("application/x-shockwave-flash", "swf", 5);
        add("application/x-stuffit", "sit", 5);
        add("application/x-sv4cpio", "sv4cpio", 5);
        add("application/x-sv4crc", "sv4crc", 5);
        add("application/x-tar", "tar", 8);
        add("application/x-texinfo", "texinfo", 5);
        add("application/x-texinfo", "texi", 5);
        add("application/x-troff", "t", 5);
        add("application/x-troff", "roff", 5);
        add("application/x-troff-man", "man", 5);
        add("application/x-ustar", "ustar", 5);
        add("application/x-wais-source", "src", 5);
        add("application/x-wingz", "wz", 5);
        add("application/x-webarchive", "webarchive", 5);
        add("application/x-webarchive-xml", "webarchivexml", 5);
        add("application/x-x509-ca-cert", "crt", 5);
        add("application/x-x509-user-cert", "crt", 5);
        add("application/x-xcf", "xcf", 5);
        add("application/x-xfig", "fig", 5);
        add("application/xhtml+xml", "xhtml", 5);
        add("application/font-sfnt", "ttf", 5);
        add(MimeTypes.AUDIO_AMR_NB, "3gpp", 1);
        add("audio/amr", "amr", 1);
        add("audio/basic", "snd", 1);
        add("audio/midi", "mid", 1);
        add("audio/midi", "midi", 1);
        add("audio/midi", "kar", 1);
        add("audio/midi", "xmf", 1);
        add("audio/mobile-xmf", "mxmf", 1);
        add(MimeTypes.AUDIO_MPEG, "mp3", 1);
        add(MimeTypes.AUDIO_MPEG, "mpga", 1);
        add(MimeTypes.AUDIO_MPEG, "mpega", 1);
        add(MimeTypes.AUDIO_MPEG, "mp2", 1);
        add(MimeTypes.AUDIO_MPEG, "m4a", 1);
        add("audio/mpegurl", "m3u", 1);
        add("audio/prs.sid", "sid", 1);
        add("audio/x-aiff", "aif", 1);
        add("audio/x-aiff", "aiff", 1);
        add("audio/x-aiff", "aifc", 1);
        add("audio/x-gsm", "gsm", 1);
        add("audio/x-mpegurl", "m3u", 1);
        add("audio/x-ms-wma", "wma", 1);
        add("audio/x-ms-wax", "wax", 1);
        add("audio/x-pn-realaudio", MultiRatePlayUrlHelper.ABBR_RATE_NAME, 1);
        add("audio/x-pn-realaudio", u.B, 1);
        add("audio/x-pn-realaudio", "ram", 1);
        add("audio/x-realaudio", MultiRatePlayUrlHelper.ABBR_RATE_NAME, 1);
        add("audio/x-scpls", "pls", 1);
        add("audio/x-sd2", "sd2", 1);
        add("audio/x-wav", "wav", 1);
        add("image/bmp", "bmp", 2);
        add("image/gif", NativeConstants.TYPE_GIF, 2);
        add("image/ico", "cur", 5);
        add("image/ico", "ico", 2);
        add("image/ief", "ief", 5);
        add("image/jpeg", "jpeg", 2);
        add("image/jpeg", "jpg", 2);
        add("image/jpeg", "jpe", 2);
        add("image/pcx", "pcx", 5);
        add(WordCommandManager.IMAGE_PNG, "png", 2);
        add("image/svg+xml", "svg", 5);
        add("image/svg+xml", "svgz", 5);
        add("image/tiff", "tiff", 5);
        add("image/tiff", "tif", 5);
        add("image/vnd.djvu", "djvu", 5);
        add("image/vnd.djvu", "djv", 5);
        add(Downsampler.WBMP_MIME_TYPE, "wbmp", 2);
        add("image/webp", WebpUtils.TYPE_IMG_WEBP, 2);
        add("image/x-cmu-raster", "ras", 5);
        add("image/x-coreldraw", "cdr", 5);
        add("image/x-coreldrawpattern", "pat", 5);
        add("image/x-coreldrawtemplate", "cdt", 5);
        add("image/x-corelphotopaint", "cpt", 5);
        add("image/x-icon", "ico", 2);
        add("image/x-jg", "art", 5);
        add("image/x-jng", "jng", 5);
        add("image/x-ms-bmp", "bmp", 2);
        add("image/x-photoshop", "psd", 5);
        add("image/x-portable-anymap", "pnm", 5);
        add("image/x-portable-bitmap", "pbm", 5);
        add("image/x-portable-graymap", "pgm", 5);
        add("image/x-portable-pixmap", "ppm", 5);
        add("image/x-rgb", ColorParser.RGB, 5);
        add("image/x-xbitmap", "xbm", 5);
        add("image/x-xpixmap", "xpm", 5);
        add("image/x-xwindowdump", "xwd", 5);
        add("model/iges", "igs", 5);
        add("model/iges", "iges", 5);
        add("model/mesh", "msh", 5);
        add("model/mesh", "mesh", 5);
        add("model/mesh", "silo", 5);
        add("text/calendar", "ics", 5);
        add("text/calendar", "icz", 5);
        add("text/comma-separated-values", "csv", 5);
        add("text/css", "css", 5);
        add(SapiWebView.DATA_MIME_TYPE, "htm", 11);
        add(SapiWebView.DATA_MIME_TYPE, IMConstants.IM_RECEIVE_SERVER_COMMON_TYPE_HTML, 11);
        add("text/h323", "323", 5);
        add("text/iuls", "uls", 5);
        add("text/mathml", "mml", 5);
        add(DownloadConstants.STORY_MIMETYPE, "txt", 6);
        add("text/plain", "dat", 5);
        add("text/plain", "txt", 4);
        add("text/plain", "asc", 5);
        add("text/plain", "text", 4);
        add("text/plain", "diff", 5);
        add("text/plain", "po", 5);
        add("text/richtext", "rtx", 5);
        add("text/rtf", "rtf", 5);
        add("text/texmacs", "ts", 5);
        add("text/text", "phps", 5);
        add("text/tab-separated-values", "tsv", 5);
        add("text/xml", "xml", 5);
        add("text/x-bibtex", "bib", 5);
        add("text/x-boo", "boo", 5);
        add("text/x-c++hdr", "h++", 5);
        add("text/x-c++hdr", "hpp", 5);
        add("text/x-c++hdr", "hxx", 5);
        add("text/x-c++hdr", "hh", 5);
        add("text/x-c++src", "c++", 5);
        add("text/x-c++src", "cpp", 5);
        add("text/x-c++src", "cxx", 5);
        add("text/x-chdr", "h", 5);
        add("text/x-component", "htc", 5);
        add("text/x-csh", "csh", 5);
        add("text/x-csrc", "c", 5);
        add("text/x-dsrc", "d", 5);
        add("text/x-haskell", "hs", 5);
        add("text/x-java", ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA, 5);
        add("text/x-literate-haskell", "lhs", 5);
        add("text/x-moc", "moc", 5);
        add("text/x-pascal", "p", 5);
        add("text/x-pascal", "pas", 5);
        add("text/x-pcs-gcd", "gcd", 5);
        add("text/x-setext", "etx", 5);
        add("text/x-tcl", "tcl", 5);
        add("text/x-tex", "tex", 5);
        add("text/x-tex", "ltx", 5);
        add("text/x-tex", "sty", 5);
        add("text/x-tex", "cls", 5);
        add("text/x-vcalendar", "vcs", 5);
        add("text/x-vcard", "vcf", 5);
        add("video/mkv", "mkv", 0);
        add(MimeTypes.VIDEO_H263, "3gpp", 0);
        add(MimeTypes.VIDEO_H263, "3gp", 0);
        add(MimeTypes.VIDEO_H263, "3g2", 0);
        add("video/dl", "dl", 0);
        add("video/dv", "dif", 0);
        add("video/dv", "dv", 0);
        add("video/fli", "fli", 0);
        add("video/m4v", "m4v", 0);
        add("video/mpeg", "mpeg", 0);
        add("video/mpeg", "mpg", 0);
        add("video/mpeg", "mpe", 0);
        add("video/mp4", DownloadStatisticConstants.UBC_TYPE_MP4, 0);
        add("video/mpeg", "vob", 0);
        add("video/quicktime", "qt", 0);
        add("video/quicktime", "mov", 0);
        add("video/vnd.mpegurl", "mxu", 0);
        add("video/x-la-asf", "lsf", 0);
        add("video/x-la-asf", "lsx", 0);
        add("video/x-mng", "mng", 0);
        add("video/x-ms-asf", "asf", 0);
        add("video/x-ms-asf", "asx", 0);
        add("video/x-ms-wm", "wm", 0);
        add("video/x-ms-wmv", "wmv", 0);
        add("video/x-ms-wmx", "wmx", 0);
        add("video/x-ms-wvx", "wvx", 0);
        add("video/x-msvideo", "avi", 0);
        add("video/x-sgi-movie", "movie", 0);
        add("video/x-webex", "wrf", 0);
        add("x-conference/x-cooltalk", "ice", 5);
        add("x-epoc/x-sisx-app", "sisx", 5);
        add("video/vnd.rn-realvideo", "rmvb", 0);
        add("video/x-flv", "flv", 0);
        add("audio/aac", "aac", 1);
        add("application/vnd.rn-realmedia", u.B, 0);
        add("message/rfc822", "mht", 11);
        add("application/x.mpegurl", DownloadStatisticConstants.UBC_TYPE_M3U8, 0);
        add("application/vnd.apple.mpegurl", DownloadStatisticConstants.UBC_TYPE_M3U8, 0);
        add("application/x.mpegurl", "m3u", 0);
        add("application/vnd.apple.mpegurl", "m3u", 0);
        add("application/x.mpegURL", DownloadStatisticConstants.UBC_TYPE_M3U8, 0);
        add("application/vnd.apple.mpegURL", DownloadStatisticConstants.UBC_TYPE_M3U8, 0);
        add("application/x.mpegURL", "m3u", 0);
        add("application/vnd.apple.mpegURL", "m3u", 0);
        add("video/vnd.rn-realvideo", "rv", 0);
        add("video/x-ivf", "ivf", 0);
        add("image/tiff", "tiff", 2);
        CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    }

    public static void add(String str, String str2, int i) {
        sExtTypeMap.put(str2, Integer.valueOf(i));
        sMimeTypeMap.put(str, Integer.valueOf(i));
        HashMap<String, Integer> hashMap = sMimeTypeExtensionToTypeMap;
        hashMap.put(str + "@" + str2, Integer.valueOf(i));
        sExtensionToMimeTypeMap.put(str2, str);
        if (!sMimeTypeToExtensionMap.containsKey(str)) {
            sMimeTypeToExtensionMap.put(str, str2);
        }
    }

    public static FileInputStream getApkFileInputStream(String str) {
        try {
            if (DownloadMediaHelper.needMediaFileProcessor(str)) {
                ParcelFileDescriptor openFileDescriptor = AppRuntime.getAppContext().getContentResolver().openFileDescriptor(DownloadMediaHelper.queryMediaFileUri(AppRuntime.getAppContext(), str, "application/vnd.android.package-archive"), "w", null);
                if (openFileDescriptor != null) {
                    return new FileInputStream(openFileDescriptor.getFileDescriptor());
                }
            } else if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                return new FileInputStream(str);
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "文件找不到 " + e);
            }
        }
        return null;
    }

    public static int getCategory(String str) {
        return getCategory(str, "");
    }

    public static String getFileNameExcludeExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String fileSuffix = getFileSuffix(str);
        if (sExtTypeMap.get(fileSuffix) != null) {
            return str.substring(0, (str.length() - fileSuffix.length()) - 1);
        }
        return str;
    }

    public static String getFileNameFromPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1 && lastIndexOf != str.length()) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static String getFileSuffix(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length()) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String guessExtensionFromMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sMimeTypeToExtensionMap.get(str);
    }

    public static String guessMimeTypeFromExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sExtensionToMimeTypeMap.get(str);
    }

    public static String parseContentDisposition(String str) {
        return DownloadHelper.parseContentDisposition(str);
    }

    public static int getCategory(String str, String str2) {
        String str3;
        Integer num;
        if (!TextUtils.isEmpty(str)) {
            str3 = str.toLowerCase(Locale.getDefault());
        } else {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            HashMap<String, Integer> hashMap = sMimeTypeExtensionToTypeMap;
            num = hashMap.get(str2 + "@" + str3);
            if (num == null) {
                num = sExtTypeMap.get(str3);
            }
            if (num == null) {
                num = sMimeTypeMap.get(str2);
            }
        } else if (TextUtils.isEmpty(str2)) {
            num = sExtTypeMap.get(str3);
        } else {
            num = sMimeTypeMap.get(str2);
        }
        if (num == null) {
            num = 5;
        }
        return num.intValue();
    }

    @Deprecated
    public static int getCategory(String str, String str2, boolean z) {
        return getCategory(str, str2);
    }

    public static boolean isDownloadingApk(String str, String str2, String str3) {
        if (getCategory(getFileSuffix(guessFileName(str, str2, str3)), str3) == 3) {
            return true;
        }
        return false;
    }

    public static List<String> getExtensionsByType(int i) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Integer> hashMap = sMimeTypeExtensionToTypeMap;
        if (hashMap != null) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue().intValue() == i) {
                    arrayList.add(entry.getKey().substring(entry.getKey().indexOf("@") + 1));
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public static ArrayList<String> getMimeTypesByType(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = sMimeTypeExtensionToTypeMap;
        if (hashMap != null) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue().intValue() == i) {
                    arrayList.add(entry.getKey().substring(0, entry.getKey().indexOf("@")));
                }
            }
        }
        return arrayList;
    }

    public static String getSQliteSelectionByCategory(int i, List<String> list) {
        if (list == null || list.size() == 0) {
            list = getMimeTypesByType(i);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append("'");
            sb.append(str);
            sb.append("',");
        }
        String substring = sb.substring(0, sb.length() - 1);
        List<String> extensionsByType = getExtensionsByType(i);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = extensionsByType.iterator();
        while (it.hasNext()) {
            sb2.append(" OR _data LIKE '%." + it.next() + "'");
        }
        return (" AND ( mimetype IN (" + substring + " ) ") + sb2.toString() + " ) ";
    }

    public static String guessFileName(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int lastIndexOf;
        int lastIndexOf2;
        String str11 = null;
        if (str2 != null) {
            str4 = parseContentDisposition(str2);
            if (!TextUtils.isEmpty(str4) && (lastIndexOf2 = str4.lastIndexOf(File.separator) + 1) > 0) {
                str4 = str4.substring(lastIndexOf2);
            }
        } else {
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = FileUtils.getFileNameFromUrl(str);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = "downloadfile";
        }
        int lastIndexOf3 = str4.lastIndexOf(".");
        if (lastIndexOf3 < 0) {
            if (str3 != null) {
                str10 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                if (TextUtils.isEmpty(str10)) {
                    if (str3.toLowerCase(Locale.getDefault()).startsWith("image/")) {
                        str10 = ".jpg";
                    }
                } else {
                    str10 = "." + str10;
                }
            } else {
                str10 = null;
            }
            if (str10 == null) {
                if (str3 != null && str3.toLowerCase(Locale.getDefault()).startsWith("text/")) {
                    if (str3.equalsIgnoreCase(SapiWebView.DATA_MIME_TYPE)) {
                        str10 = ".html";
                    } else {
                        str10 = ".txt";
                    }
                } else {
                    String fileNameFromUrl = FileUtils.getFileNameFromUrl(str);
                    if (!TextUtils.isEmpty(fileNameFromUrl) && (lastIndexOf = fileNameFromUrl.lastIndexOf(".")) != -1) {
                        str11 = fileNameFromUrl.substring(lastIndexOf + 1);
                    }
                    if (!TextUtils.isEmpty(str11)) {
                        str5 = "." + str11;
                    } else {
                        str5 = ".bin";
                    }
                }
            }
            if (str4 != null && str4.length() > 50) {
                str4 = str4.substring(0, 50);
            }
            return str4 + str10;
        }
        if (str3 != null) {
            String substring = str4.substring(str4.lastIndexOf(".") + 1);
            String guessExtensionFromMimeType = guessExtensionFromMimeType(str3);
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
            String str12 = "";
            if (TextUtils.isEmpty(substring)) {
                str6 = "";
            } else {
                str6 = substring.toLowerCase(Locale.getDefault());
            }
            if (TextUtils.isEmpty(guessExtensionFromMimeType)) {
                str7 = "";
            } else {
                str7 = guessExtensionFromMimeType.toLowerCase(Locale.getDefault());
            }
            if (TextUtils.isEmpty(extensionFromMimeType)) {
                str8 = "";
            } else {
                str8 = extensionFromMimeType.toLowerCase(Locale.getDefault());
            }
            String guessMimeTypeFromExtension = guessMimeTypeFromExtension(str6);
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str6);
            if (TextUtils.isEmpty(guessMimeTypeFromExtension)) {
                str9 = "";
            } else {
                str9 = guessMimeTypeFromExtension.toLowerCase(Locale.getDefault());
            }
            if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                str12 = mimeTypeFromExtension.toLowerCase(Locale.getDefault());
            }
            if (TextUtils.equals(str9, str12)) {
                if (!TextUtils.isEmpty(str7) && TextUtils.equals(str7, str8)) {
                    str11 = "." + str7;
                }
            } else if (TextUtils.isEmpty(str9)) {
                if (!TextUtils.isEmpty(str8)) {
                    str11 = "." + str8;
                }
            } else if (TextUtils.isEmpty(str12)) {
                if (!TextUtils.isEmpty(str9)) {
                    str11 = "." + str6;
                } else if (!TextUtils.isEmpty(str7)) {
                    str11 = "." + str7;
                }
            }
        }
        if (str11 == null) {
            str5 = str4.substring(lastIndexOf3);
        } else {
            str5 = str11;
        }
        str4 = str4.substring(0, lastIndexOf3);
        str10 = str5;
        if (str4 != null) {
            str4 = str4.substring(0, 50);
        }
        return str4 + str10;
    }

    public static boolean isAPK(String str) {
        ZipInputStream zipInputStream;
        IOException iOException;
        ZipEntry nextEntry;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream apkFileInputStream = getApkFileInputStream(str);
            try {
                if (apkFileInputStream == null) {
                    if (DEBUG) {
                        Log.e(TAG, "apk文件找不到");
                    }
                    Closeables.closeSafely(apkFileInputStream);
                    Closeables.closeSafely((Closeable) null);
                    return false;
                }
                zipInputStream = new ZipInputStream(apkFileInputStream);
                do {
                    try {
                        nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            if (nextEntry.isDirectory()) {
                                break;
                            }
                        } else {
                            if (DEBUG) {
                                Log.e(TAG, "不是APK文件，找不到AndroidManifest.xml");
                            }
                            Closeables.closeSafely(apkFileInputStream);
                            Closeables.closeSafely(zipInputStream);
                            return false;
                        }
                    } catch (IOException e) {
                        fileInputStream = apkFileInputStream;
                        iOException = e;
                        try {
                            if (DEBUG) {
                                Log.e(TAG, "解析APK出错:" + iOException.getMessage());
                            }
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(zipInputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(zipInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = apkFileInputStream;
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(zipInputStream);
                        throw th;
                    }
                } while (!nextEntry.getName().equals("AndroidManifest.xml"));
                if (DEBUG) {
                    Log.e(TAG, "解析APK文件成功");
                }
                Closeables.closeSafely(apkFileInputStream);
                Closeables.closeSafely(zipInputStream);
                return true;
            } catch (IOException e2) {
                fileInputStream = apkFileInputStream;
                iOException = e2;
                zipInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                zipInputStream = null;
            }
        } catch (IOException e3) {
            iOException = e3;
            zipInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipInputStream = null;
        }
    }

    public static boolean isVideoKernelSupport(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (!"m3u".equals(lowerCase) && !"f4v".equals(lowerCase) && !"asf".equals(lowerCase) && !"wmv".equals(lowerCase) && !"avi".equals(lowerCase) && !"flv".equals(lowerCase) && !"mkv".equals(lowerCase) && !"mov".equals(lowerCase) && !DownloadStatisticConstants.UBC_TYPE_MP4.equals(lowerCase) && !"3gp".equals(lowerCase) && !"3g2".equals(lowerCase) && !"mpg".equals(lowerCase) && !"mpeg".equals(lowerCase) && !"ts".equals(lowerCase) && !"rv".equals(lowerCase) && !"ivf".equals(lowerCase) && !u.B.equals(lowerCase) && !"rmvb".equals(lowerCase) && !DownloadStatisticConstants.UBC_TYPE_M3U8.equals(lowerCase) && !MatroskaExtractor.DOC_TYPE_WEBM.equals(lowerCase)) {
            return false;
        }
        return true;
    }

    public static boolean isNeedReplaceMimetype(String str, String str2) {
        List<String> list;
        if (mNeedReplaceMimetype == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !mNeedReplaceMimetype.containsKey(str) || (list = mNeedReplaceMimetype.get(str)) == null || list.isEmpty()) {
            return false;
        }
        for (String str3 : list) {
            if (TextUtils.equals(str3, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOtherCategory(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int category = getCategory(str2, str);
        if (category != 5 && category != 2) {
            return false;
        }
        return true;
    }
}
