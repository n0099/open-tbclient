package com.baidu.swan.apps.aq;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.android.util.media.MimeType;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.ugc.transcoder.TranscoderPlugin;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public final class p {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Pattern cJY = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static HashMap<String, Integer> cJZ = new HashMap<>();
    private static HashMap<String, Integer> cKa = new HashMap<>();
    private static HashMap<String, String> cKb = new HashMap<>();
    private static HashMap<String, String> cKc = new HashMap<>();
    private static final Pattern cKd;

    static {
        f("application/andrew-inset", "ez", 5);
        f("application/dsptype", "tsp", 5);
        f("application/futuresplash", "spl", 5);
        f("application/hta", "hta", 5);
        f("application/mac-binhex40", "hqx", 5);
        f("application/mac-compactpro", "cpt", 5);
        f("application/mathematica", "nb", 5);
        f("application/msaccess", "mdb", 5);
        f("application/oda", "oda", 5);
        f("application/ogg", "ogg", 1);
        f(DocumentOpenUtil.PDF_TYPE, DocumentOpenUtil.PDF, 4);
        f("application/pgp-keys", "key", 5);
        f("application/pgp-signature", "pgp", 5);
        f("application/pics-rules", "prf", 5);
        f("application/rar", "rar", 8);
        f("application/rdf+xml", "rdf", 5);
        f("application/rss+xml", "rss", 5);
        f("application/zip", "zip", 8);
        f("application/vnd.android.package-archive", "apk", 3);
        f("application/vnd.cinderella", "cdy", 5);
        f("application/vnd.ms-pki.stl", "stl", 5);
        f("application/vnd.oasis.opendocument.database", "odb", 5);
        f("application/vnd.oasis.opendocument.formula", "odf", 5);
        f("application/vnd.oasis.opendocument.graphics", "odg", 5);
        f("application/vnd.oasis.opendocument.graphics-template", "otg", 5);
        f("application/vnd.oasis.opendocument.image", "odi", 5);
        f("application/vnd.oasis.opendocument.spreadsheet", "ods", 5);
        f("application/vnd.oasis.opendocument.spreadsheet-template", "ots", 5);
        f("application/vnd.oasis.opendocument.text", "odt", 5);
        f("application/vnd.oasis.opendocument.text-master", "odm", 5);
        f("application/vnd.oasis.opendocument.text-template", "ott", 5);
        f("application/vnd.oasis.opendocument.text-web", "oth", 5);
        f("application/vnd.google-earth.kml+xml", "kml", 5);
        f("application/vnd.google-earth.kmz", "kmz", 5);
        f(DocumentOpenUtil.WORD_TYPE, DocumentOpenUtil.DOC, 4);
        f(DocumentOpenUtil.WORD_TYPE, "dot", 4);
        f(DocumentOpenUtil.DOCUMENT_TYPE, DocumentOpenUtil.DOCX, 4);
        f("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", 4);
        f(DocumentOpenUtil.EXCEL_TYPE, DocumentOpenUtil.XLS, 4);
        f(DocumentOpenUtil.EXCEL_TYPE, "xlt", 4);
        f(DocumentOpenUtil.SHEET_TYPE, DocumentOpenUtil.XLSX, 4);
        f("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", 4);
        f(DocumentOpenUtil.PPT_TYPE, DocumentOpenUtil.PPT, 4);
        f(DocumentOpenUtil.PPT_TYPE, "pot", 4);
        f(DocumentOpenUtil.PPT_TYPE, "pps", 4);
        f(DocumentOpenUtil.PRESENT_TYPE, DocumentOpenUtil.PPTX, 4);
        f("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", 4);
        f("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", 4);
        f("application/vnd.rim.cod", "cod", 5);
        f("application/vnd.smaf", "mmf", 5);
        f("application/vnd.stardivision.calc", "sdc", 5);
        f("application/vnd.stardivision.draw", "sda", 5);
        f("application/vnd.stardivision.impress", "sdd", 5);
        f("application/vnd.stardivision.impress", "sdp", 5);
        f("application/vnd.stardivision.math", "smf", 5);
        f("application/vnd.stardivision.writer", "sdw", 5);
        f("application/vnd.stardivision.writer", "vor", 5);
        f("application/vnd.stardivision.writer-global", "sgl", 5);
        f("application/vnd.sun.xml.calc", "sxc", 5);
        f("application/vnd.sun.xml.calc.template", "stc", 5);
        f("application/vnd.sun.xml.draw", "sxd", 5);
        f("application/vnd.sun.xml.draw.template", "std", 5);
        f("application/vnd.sun.xml.impress", "sxi", 5);
        f("application/vnd.sun.xml.impress.template", "sti", 5);
        f("application/vnd.sun.xml.math", "sxm", 5);
        f("application/vnd.sun.xml.writer", "sxw", 5);
        f("application/vnd.sun.xml.writer.global", "sxg", 5);
        f("application/vnd.sun.xml.writer.template", "stw", 5);
        f("application/vnd.visio", "vsd", 5);
        f("application/x-abiword", "abw", 5);
        f("application/x-apple-diskimage", "dmg", 5);
        f("application/x-bcpio", "bcpio", 5);
        f("application/x-bittorrent", "torrent", 5);
        f("application/x-cdf", "cdf", 5);
        f("application/x-cdlink", "vcd", 5);
        f("application/x-chess-pgn", "pgn", 5);
        f("application/x-cpio", "cpio", 5);
        f("application/x-debian-package", "deb", 5);
        f("application/x-debian-package", "udeb", 5);
        f("application/x-director", "dcr", 5);
        f("application/x-director", "dir", 5);
        f("application/x-director", "dxr", 5);
        f("application/x-dms", "dms", 5);
        f("application/x-doom", "wad", 5);
        f("application/x-dvi", "dvi", 5);
        f("application/x-flac", "flac", 1);
        f("application/x-font", "pfa", 5);
        f("application/x-font", "pfb", 5);
        f("application/x-font", "gsf", 5);
        f("application/x-font", "pcf", 5);
        f("application/x-font", "pcf.Z", 5);
        f("application/x-freemind", "mm", 5);
        f("application/x-futuresplash", "spl", 5);
        f("application/x-gnumeric", "gnumeric", 5);
        f("application/x-go-sgf", "sgf", 5);
        f("application/x-graphing-calculator", "gcf", 5);
        f("application/x-gtar", "gtar", 5);
        f("application/x-gtar", "tgz", 5);
        f("application/x-gtar", "taz", 5);
        f("application/x-hdf", "hdf", 5);
        f("application/x-ica", "ica", 5);
        f("application/x-internet-signup", "ins", 5);
        f("application/x-internet-signup", "isp", 5);
        f("application/x-iphone", "iii", 5);
        f("application/x-iso9660-image", "iso", 5);
        f("application/x-jmol", "jmz", 5);
        f("application/x-kchart", "chrt", 5);
        f("application/x-killustrator", "kil", 5);
        f("application/x-koan", "skp", 5);
        f("application/x-koan", "skd", 5);
        f("application/x-koan", "skt", 5);
        f("application/x-koan", "skm", 5);
        f("application/x-kpresenter", "kpr", 5);
        f("application/x-kpresenter", "kpt", 5);
        f("application/x-kspread", "ksp", 5);
        f("application/x-kword", "kwd", 5);
        f("application/x-kword", "kwt", 5);
        f("application/x-latex", "latex", 5);
        f("application/x-lha", "lha", 5);
        f("application/x-lzh", "lzh", 5);
        f("application/x-lzx", "lzx", 5);
        f("application/x-maker", "frm", 5);
        f("application/x-maker", "maker", 5);
        f("application/x-maker", "frame", 5);
        f("application/x-maker", "fb", 5);
        f("application/x-maker", "book", 5);
        f("application/x-maker", "fbdoc", 5);
        f("application/x-mif", "mif", 5);
        f("application/x-ms-wmd", "wmd", 5);
        f("application/x-ms-wmz", "wmz", 5);
        f("application/x-msi", "msi", 5);
        f("application/x-ns-proxy-autoconfig", "pac", 5);
        f("application/x-nwc", "nwc", 5);
        f("application/x-object", Config.OS, 5);
        f("application/x-oz-application", "oza", 5);
        f("application/x-pkcs12", "p12", 5);
        f("application/x-pkcs12", "pfx", 5);
        f("application/x-pkcs7-certreqresp", "p7r", 5);
        f("application/x-pkcs7-crl", "crl", 5);
        f("application/x-quicktimeplayer", "qtl", 5);
        f("application/x-shar", "shar", 5);
        f("application/x-shockwave-flash", "swf", 5);
        f("application/x-stuffit", "sit", 5);
        f("application/x-sv4cpio", "sv4cpio", 5);
        f("application/x-sv4crc", "sv4crc", 5);
        f("application/x-tar", "tar", 8);
        f("application/x-texinfo", "texinfo", 5);
        f("application/x-texinfo", "texi", 5);
        f("application/x-troff", "t", 5);
        f("application/x-troff", "roff", 5);
        f("application/x-troff-man", "man", 5);
        f("application/x-ustar", "ustar", 5);
        f("application/x-wais-source", UserAccountActionItem.KEY_SRC, 5);
        f("application/x-wingz", "wz", 5);
        f("application/x-webarchive", "webarchive", 5);
        f("application/x-webarchive-xml", "webarchivexml", 5);
        f("application/x-x509-ca-cert", "crt", 5);
        f("application/x-x509-user-cert", "crt", 5);
        f("application/x-xcf", "xcf", 5);
        f("application/x-xfig", "fig", 5);
        f("application/xhtml+xml", "xhtml", 5);
        f("application/font-sfnt", "ttf", 5);
        f("audio/3gpp", "3gpp", 1);
        f(MimeType.Audio.AMR, "amr", 1);
        f("audio/basic", "snd", 1);
        f("audio/midi", "mid", 1);
        f("audio/midi", "midi", 1);
        f("audio/midi", "kar", 1);
        f("audio/midi", "xmf", 1);
        f("audio/mobile-xmf", "mxmf", 1);
        f("audio/mpeg", "mp3", 1);
        f("audio/mpeg", "mpga", 1);
        f("audio/mpeg", "mpega", 1);
        f("audio/mpeg", "mp2", 1);
        f("audio/mpeg", "m4a", 1);
        f("audio/mpegurl", "m3u", 1);
        f("audio/prs.sid", UbcStatConstant.KEY_CONTENT_EXT_SID, 1);
        f("audio/x-aiff", "aif", 1);
        f("audio/x-aiff", "aiff", 1);
        f("audio/x-aiff", "aifc", 1);
        f("audio/x-gsm", "gsm", 1);
        f("audio/x-mpegurl", "m3u", 1);
        f("audio/x-ms-wma", "wma", 1);
        f("audio/x-ms-wax", "wax", 1);
        f("audio/x-pn-realaudio", "ra", 1);
        f("audio/x-pn-realaudio", "rm", 1);
        f("audio/x-pn-realaudio", "ram", 1);
        f("audio/x-realaudio", "ra", 1);
        f("audio/x-scpls", "pls", 1);
        f("audio/x-sd2", "sd2", 1);
        f(MimeType.Audio.WAV, "wav", 1);
        f("image/bmp", "bmp", 2);
        f("image/gif", "gif", 2);
        f("image/ico", "cur", 5);
        f("image/ico", "ico", 2);
        f("image/ief", "ief", 5);
        f(MimeType.Image.JPEG, "jpeg", 2);
        f(MimeType.Image.JPEG, "jpg", 2);
        f(MimeType.Image.JPEG, "jpe", 2);
        f("image/pcx", "pcx", 5);
        f(MimeType.Image.PNG, "png", 2);
        f("image/svg+xml", "svg", 5);
        f("image/svg+xml", "svgz", 5);
        f("image/tiff", "tiff", 5);
        f("image/tiff", "tif", 5);
        f("image/vnd.djvu", "djvu", 5);
        f("image/vnd.djvu", "djv", 5);
        f("image/vnd.wap.wbmp", "wbmp", 2);
        f("image/x-cmu-raster", "ras", 5);
        f("image/x-coreldraw", "cdr", 5);
        f("image/x-coreldrawpattern", "pat", 5);
        f("image/x-coreldrawtemplate", "cdt", 5);
        f("image/x-corelphotopaint", "cpt", 5);
        f("image/x-icon", "ico", 2);
        f("image/x-jg", "art", 5);
        f("image/x-jng", "jng", 5);
        f("image/x-ms-bmp", "bmp", 2);
        f("image/x-photoshop", "psd", 5);
        f("image/x-portable-anymap", "pnm", 5);
        f("image/x-portable-bitmap", "pbm", 5);
        f("image/x-portable-graymap", "pgm", 5);
        f("image/x-portable-pixmap", "ppm", 5);
        f("image/x-rgb", "rgb", 5);
        f("image/x-xbitmap", "xbm", 5);
        f("image/x-xpixmap", "xpm", 5);
        f("image/x-xwindowdump", "xwd", 5);
        f("model/iges", "igs", 5);
        f("model/iges", "iges", 5);
        f("model/mesh", "msh", 5);
        f("model/mesh", "mesh", 5);
        f("model/mesh", "silo", 5);
        f("text/calendar", "ics", 5);
        f("text/calendar", "icz", 5);
        f("text/comma-separated-values", "csv", 5);
        f("text/css", "css", 5);
        f("text/html", "htm", 11);
        f("text/html", "html", 11);
        f("text/h323", "323", 5);
        f("text/iuls", "uls", 5);
        f("text/mathml", "mml", 5);
        f("text/plain-story", DocumentOpenUtil.TXT, 6);
        f("text/plain", "dat", 5);
        f("text/plain", DocumentOpenUtil.TXT, 4);
        f("text/plain", "asc", 4);
        f("text/plain", "text", 4);
        f("text/plain", "diff", 4);
        f("text/plain", "po", 4);
        f("text/richtext", "rtx", 4);
        f("text/rtf", "rtf", 4);
        f("text/texmacs", TimeDisplaySetting.TIME_DISPLAY_SETTING, 5);
        f("text/text", "phps", 5);
        f("text/tab-separated-values", "tsv", 5);
        f("text/xml", "xml", 4);
        f("text/x-bibtex", "bib", 5);
        f("text/x-boo", "boo", 5);
        f("text/x-c++hdr", "h++", 5);
        f("text/x-c++hdr", "hpp", 5);
        f("text/x-c++hdr", "hxx", 5);
        f("text/x-c++hdr", "hh", 5);
        f("text/x-c++src", "c++", 5);
        f("text/x-c++src", "cpp", 5);
        f("text/x-c++src", "cxx", 5);
        f("text/x-chdr", "h", 5);
        f("text/x-component", "htc", 5);
        f("text/x-csh", "csh", 5);
        f("text/x-csrc", "c", 5);
        f("text/x-dsrc", "d", 5);
        f("text/x-haskell", "hs", 5);
        f("text/x-java", "java", 5);
        f("text/x-literate-haskell", "lhs", 5);
        f("text/x-moc", "moc", 5);
        f("text/x-pascal", "p", 5);
        f("text/x-pascal", "pas", 5);
        f("text/x-pcs-gcd", "gcd", 5);
        f("text/x-setext", "etx", 5);
        f("text/x-tcl", "tcl", 5);
        f("text/x-tex", "tex", 5);
        f("text/x-tex", "ltx", 5);
        f("text/x-tex", "sty", 5);
        f("text/x-tex", "cls", 5);
        f("text/x-vcalendar", "vcs", 5);
        f("text/x-vcard", "vcf", 5);
        f("video/mkv", "mkv", 0);
        f(MimeType.Video.GP3, "3gpp", 0);
        f(MimeType.Video.GP3, "3gp", 0);
        f(MimeType.Video.GP3, "3g2", 0);
        f("video/dl", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, 0);
        f("video/dv", "dif", 0);
        f("video/dv", "dv", 0);
        f("video/fli", "fli", 0);
        f("video/m4v", "m4v", 0);
        f(MimeType.Video.MPEG, "mpeg", 0);
        f(MimeType.Video.MPEG, "mpg", 0);
        f(MimeType.Video.MPEG, "mpe", 0);
        f(MimeType.Video.MP4, "mp4", 0);
        f(MimeType.Video.MPEG, "vob", 0);
        f("video/quicktime", "qt", 0);
        f("video/quicktime", "mov", 0);
        f("video/vnd.mpegurl", "mxu", 0);
        f("video/x-la-asf", "lsf", 0);
        f("video/x-la-asf", "lsx", 0);
        f("video/x-mng", "mng", 0);
        f("video/x-ms-asf", "asf", 0);
        f("video/x-ms-asf", "asx", 0);
        f("video/x-ms-wm", "wm", 0);
        f("video/x-ms-wmv", "wmv", 0);
        f("video/x-ms-wmx", "wmx", 0);
        f("video/x-ms-wvx", "wvx", 0);
        f("video/x-msvideo", "avi", 0);
        f("video/x-sgi-movie", "movie", 0);
        f("video/x-webex", "wrf", 0);
        f("x-conference/x-cooltalk", "ice", 5);
        f("x-epoc/x-sisx-app", "sisx", 5);
        f("video/vnd.rn-realvideo", "rmvb", 0);
        f("video/x-flv", "flv", 0);
        f("audio/aac", TranscoderPlugin.AUDIO_CODEC, 1);
        f("application/vnd.rn-realmedia", "rm", 0);
        f("message/rfc822", "mht", 11);
        cKd = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    }

    private static void f(String str, String str2, int i) {
        cJZ.put(str2, Integer.valueOf(i));
        cKa.put(str, Integer.valueOf(i));
        cKb.put(str2, str);
        if (!cKc.containsKey(str)) {
            cKc.put(str, str2);
        }
    }

    public static String pC(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length()) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    @Nullable
    public static String pD(String str) {
        if (str == null) {
            return null;
        }
        return cKc.get(str);
    }

    public static String pE(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return cKb.get(str);
    }

    public static String pF(String str) {
        try {
            Matcher matcher = cJY.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
