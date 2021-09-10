package c.a.p0.a.v2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9407a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f9408b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, Integer> f9409c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, Integer> f9410d;

    /* renamed from: e  reason: collision with root package name */
    public static HashMap<String, String> f9411e;

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f9412f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(831996420, "Lc/a/p0/a/v2/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(831996420, "Lc/a/p0/a/v2/s;");
                return;
            }
        }
        f9407a = c.a.p0.a.k.f7077a;
        f9408b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
        f9409c = new HashMap<>();
        f9410d = new HashMap<>();
        f9411e = new HashMap<>();
        f9412f = new HashMap<>();
        a("application/andrew-inset", "ez", 5);
        a("application/dsptype", "tsp", 5);
        a("application/futuresplash", "spl", 5);
        a("application/hta", "hta", 5);
        a("application/mac-binhex40", "hqx", 5);
        a("application/mac-compactpro", "cpt", 5);
        a("application/mathematica", BaseContentUploader.NB, 5);
        a("application/msaccess", "mdb", 5);
        a("application/oda", "oda", 5);
        a("application/ogg", "ogg", 1);
        a(DocumentOpenUtil.PDF_TYPE, DocumentOpenUtil.PDF, 4);
        a("application/pgp-keys", "key", 5);
        a("application/pgp-signature", "pgp", 5);
        a("application/pics-rules", "prf", 5);
        a("application/rar", "rar", 8);
        a("application/rdf+xml", "rdf", 5);
        a("application/rss+xml", "rss", 5);
        a("application/zip", "zip", 8);
        a("application/vnd.android.package-archive", "apk", 3);
        a("application/vnd.cinderella", "cdy", 5);
        a("application/vnd.ms-pki.stl", "stl", 5);
        a("application/vnd.oasis.opendocument.database", "odb", 5);
        a("application/vnd.oasis.opendocument.formula", "odf", 5);
        a("application/vnd.oasis.opendocument.graphics", "odg", 5);
        a("application/vnd.oasis.opendocument.graphics-template", "otg", 5);
        a("application/vnd.oasis.opendocument.image", "odi", 5);
        a("application/vnd.oasis.opendocument.spreadsheet", "ods", 5);
        a("application/vnd.oasis.opendocument.spreadsheet-template", "ots", 5);
        a("application/vnd.oasis.opendocument.text", "odt", 5);
        a("application/vnd.oasis.opendocument.text-master", "odm", 5);
        a("application/vnd.oasis.opendocument.text-template", "ott", 5);
        a("application/vnd.oasis.opendocument.text-web", "oth", 5);
        a("application/vnd.google-earth.kml+xml", "kml", 5);
        a("application/vnd.google-earth.kmz", "kmz", 5);
        a(DocumentOpenUtil.WORD_TYPE, DocumentOpenUtil.DOC, 4);
        a(DocumentOpenUtil.WORD_TYPE, "dot", 4);
        a(DocumentOpenUtil.DOCUMENT_TYPE, DocumentOpenUtil.DOCX, 4);
        a("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", 4);
        a(DocumentOpenUtil.EXCEL_TYPE, DocumentOpenUtil.XLS, 4);
        a(DocumentOpenUtil.EXCEL_TYPE, "xlt", 4);
        a(DocumentOpenUtil.SHEET_TYPE, DocumentOpenUtil.XLSX, 4);
        a("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", 4);
        a(DocumentOpenUtil.PPT_TYPE, DocumentOpenUtil.PPT, 4);
        a(DocumentOpenUtil.PPT_TYPE, "pot", 4);
        a(DocumentOpenUtil.PPT_TYPE, "pps", 4);
        a(DocumentOpenUtil.PRESENT_TYPE, DocumentOpenUtil.PPTX, 4);
        a("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", 4);
        a("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", 4);
        a("application/vnd.rim.cod", "cod", 5);
        a("application/vnd.smaf", "mmf", 5);
        a("application/vnd.stardivision.calc", IAdRequestParam.SDC, 5);
        a("application/vnd.stardivision.draw", "sda", 5);
        a("application/vnd.stardivision.impress", "sdd", 5);
        a("application/vnd.stardivision.impress", "sdp", 5);
        a("application/vnd.stardivision.math", "smf", 5);
        a("application/vnd.stardivision.writer", "sdw", 5);
        a("application/vnd.stardivision.writer", "vor", 5);
        a("application/vnd.stardivision.writer-global", "sgl", 5);
        a("application/vnd.sun.xml.calc", "sxc", 5);
        a("application/vnd.sun.xml.calc.template", "stc", 5);
        a("application/vnd.sun.xml.draw", "sxd", 5);
        a("application/vnd.sun.xml.draw.template", "std", 5);
        a("application/vnd.sun.xml.impress", "sxi", 5);
        a("application/vnd.sun.xml.impress.template", "sti", 5);
        a("application/vnd.sun.xml.math", "sxm", 5);
        a("application/vnd.sun.xml.writer", "sxw", 5);
        a("application/vnd.sun.xml.writer.global", "sxg", 5);
        a("application/vnd.sun.xml.writer.template", "stw", 5);
        a("application/vnd.visio", "vsd", 5);
        a("application/x-abiword", "abw", 5);
        a("application/x-apple-diskimage", "dmg", 5);
        a("application/x-bcpio", "bcpio", 5);
        a("application/x-bittorrent", "torrent", 5);
        a("application/x-cdf", "cdf", 5);
        a("application/x-cdlink", "vcd", 5);
        a("application/x-chess-pgn", "pgn", 5);
        a("application/x-cpio", "cpio", 5);
        a("application/x-debian-package", "deb", 5);
        a("application/x-debian-package", "udeb", 5);
        a("application/x-director", "dcr", 5);
        a("application/x-director", "dir", 5);
        a("application/x-director", "dxr", 5);
        a("application/x-dms", "dms", 5);
        a("application/x-doom", "wad", 5);
        a("application/x-dvi", "dvi", 5);
        a("application/x-flac", "flac", 1);
        a("application/x-font", "pfa", 5);
        a("application/x-font", "pfb", 5);
        a("application/x-font", "gsf", 5);
        a("application/x-font", "pcf", 5);
        a("application/x-font", "pcf.Z", 5);
        a("application/x-freemind", "mm", 5);
        a("application/x-futuresplash", "spl", 5);
        a("application/x-gnumeric", "gnumeric", 5);
        a("application/x-go-sgf", "sgf", 5);
        a("application/x-graphing-calculator", "gcf", 5);
        a("application/x-gtar", "gtar", 5);
        a("application/x-gtar", "tgz", 5);
        a("application/x-gtar", "taz", 5);
        a("application/x-hdf", "hdf", 5);
        a("application/x-ica", "ica", 5);
        a("application/x-internet-signup", "ins", 5);
        a("application/x-internet-signup", "isp", 5);
        a("application/x-iphone", "iii", 5);
        a("application/x-iso9660-image", "iso", 5);
        a("application/x-jmol", "jmz", 5);
        a("application/x-kchart", "chrt", 5);
        a("application/x-killustrator", "kil", 5);
        a("application/x-koan", "skp", 5);
        a("application/x-koan", "skd", 5);
        a("application/x-koan", "skt", 5);
        a("application/x-koan", "skm", 5);
        a("application/x-kpresenter", "kpr", 5);
        a("application/x-kpresenter", "kpt", 5);
        a("application/x-kspread", "ksp", 5);
        a("application/x-kword", "kwd", 5);
        a("application/x-kword", "kwt", 5);
        a("application/x-latex", "latex", 5);
        a("application/x-lha", "lha", 5);
        a("application/x-lzh", "lzh", 5);
        a("application/x-lzx", "lzx", 5);
        a("application/x-maker", "frm", 5);
        a("application/x-maker", "maker", 5);
        a("application/x-maker", "frame", 5);
        a("application/x-maker", "fb", 5);
        a("application/x-maker", "book", 5);
        a("application/x-maker", "fbdoc", 5);
        a("application/x-mif", "mif", 5);
        a("application/x-ms-wmd", "wmd", 5);
        a("application/x-ms-wmz", "wmz", 5);
        a("application/x-msi", "msi", 5);
        a("application/x-ns-proxy-autoconfig", "pac", 5);
        a("application/x-nwc", "nwc", 5);
        a("application/x-object", "o", 5);
        a("application/x-oz-application", "oza", 5);
        a("application/x-pkcs12", "p12", 5);
        a("application/x-pkcs12", "pfx", 5);
        a("application/x-pkcs7-certreqresp", "p7r", 5);
        a("application/x-pkcs7-crl", "crl", 5);
        a("application/x-quicktimeplayer", "qtl", 5);
        a("application/x-shar", "shar", 5);
        a("application/x-shockwave-flash", "swf", 5);
        a("application/x-stuffit", "sit", 5);
        a("application/x-sv4cpio", "sv4cpio", 5);
        a("application/x-sv4crc", "sv4crc", 5);
        a("application/x-tar", "tar", 8);
        a("application/x-texinfo", "texinfo", 5);
        a("application/x-texinfo", "texi", 5);
        a("application/x-troff", "t", 5);
        a("application/x-troff", "roff", 5);
        a("application/x-troff-man", "man", 5);
        a("application/x-ustar", "ustar", 5);
        a("application/x-wais-source", "src", 5);
        a("application/x-wingz", "wz", 5);
        a("application/x-webarchive", "webarchive", 5);
        a("application/x-webarchive-xml", "webarchivexml", 5);
        a("application/x-x509-ca-cert", "crt", 5);
        a("application/x-x509-user-cert", "crt", 5);
        a("application/x-xcf", "xcf", 5);
        a("application/x-xfig", "fig", 5);
        a("application/xhtml+xml", "xhtml", 5);
        a("application/font-sfnt", "ttf", 5);
        a("audio/3gpp", "3gpp", 1);
        a("audio/amr", "amr", 1);
        a("audio/basic", "snd", 1);
        a("audio/midi", "mid", 1);
        a("audio/midi", "midi", 1);
        a("audio/midi", "kar", 1);
        a("audio/midi", "xmf", 1);
        a("audio/mobile-xmf", "mxmf", 1);
        a("audio/mpeg", "mp3", 1);
        a("audio/mpeg", "mpga", 1);
        a("audio/mpeg", "mpega", 1);
        a("audio/mpeg", "mp2", 1);
        a("audio/mpeg", "m4a", 1);
        a("audio/mpegurl", "m3u", 1);
        a("audio/prs.sid", "sid", 1);
        a("audio/x-aiff", "aif", 1);
        a("audio/x-aiff", "aiff", 1);
        a("audio/x-aiff", "aifc", 1);
        a("audio/x-gsm", "gsm", 1);
        a("audio/x-mpegurl", "m3u", 1);
        a("audio/x-ms-wma", "wma", 1);
        a("audio/x-ms-wax", "wax", 1);
        a("audio/x-pn-realaudio", "ra", 1);
        a("audio/x-pn-realaudio", "rm", 1);
        a("audio/x-pn-realaudio", "ram", 1);
        a("audio/x-realaudio", "ra", 1);
        a("audio/x-scpls", "pls", 1);
        a("audio/x-sd2", "sd2", 1);
        a("audio/x-wav", "wav", 1);
        a("image/bmp", "bmp", 2);
        a("image/gif", "gif", 2);
        a("image/ico", "cur", 5);
        a("image/ico", "ico", 2);
        a("image/ief", "ief", 5);
        a("image/jpeg", "jpeg", 2);
        a("image/jpeg", "jpg", 2);
        a("image/jpeg", "jpe", 2);
        a("image/pcx", "pcx", 5);
        a("image/png", "png", 2);
        a("image/svg+xml", OvalActionButton.SVG, 5);
        a("image/svg+xml", "svgz", 5);
        a("image/tiff", "tiff", 5);
        a("image/tiff", "tif", 5);
        a("image/vnd.djvu", "djvu", 5);
        a("image/vnd.djvu", "djv", 5);
        a(Downsampler.WBMP_MIME_TYPE, "wbmp", 2);
        a("image/x-cmu-raster", "ras", 5);
        a("image/x-coreldraw", "cdr", 5);
        a("image/x-coreldrawpattern", "pat", 5);
        a("image/x-coreldrawtemplate", "cdt", 5);
        a("image/x-corelphotopaint", "cpt", 5);
        a("image/x-icon", "ico", 2);
        a("image/x-jg", "art", 5);
        a("image/x-jng", "jng", 5);
        a("image/x-ms-bmp", "bmp", 2);
        a("image/x-photoshop", "psd", 5);
        a("image/x-portable-anymap", "pnm", 5);
        a("image/x-portable-bitmap", "pbm", 5);
        a("image/x-portable-graymap", "pgm", 5);
        a("image/x-portable-pixmap", "ppm", 5);
        a("image/x-rgb", "rgb", 5);
        a("image/x-xbitmap", "xbm", 5);
        a("image/x-xpixmap", "xpm", 5);
        a("image/x-xwindowdump", "xwd", 5);
        a("model/iges", "igs", 5);
        a("model/iges", "iges", 5);
        a("model/mesh", "msh", 5);
        a("model/mesh", "mesh", 5);
        a("model/mesh", "silo", 5);
        a("text/calendar", "ics", 5);
        a("text/calendar", "icz", 5);
        a("text/comma-separated-values", "csv", 5);
        a("text/css", "css", 5);
        a(SapiWebView.DATA_MIME_TYPE, "htm", 11);
        a(SapiWebView.DATA_MIME_TYPE, "html", 11);
        a("text/h323", "323", 5);
        a("text/iuls", "uls", 5);
        a("text/mathml", "mml", 5);
        a("text/plain-story", DocumentOpenUtil.TXT, 6);
        a("text/plain", "dat", 5);
        a("text/plain", DocumentOpenUtil.TXT, 4);
        a("text/plain", "asc", 4);
        a("text/plain", "text", 4);
        a("text/plain", "diff", 4);
        a("text/plain", "po", 4);
        a("text/richtext", "rtx", 4);
        a("text/rtf", "rtf", 4);
        a("text/texmacs", "ts", 5);
        a("text/text", "phps", 5);
        a("text/tab-separated-values", "tsv", 5);
        a("text/xml", "xml", 4);
        a("text/x-bibtex", "bib", 5);
        a("text/x-boo", "boo", 5);
        a("text/x-c++hdr", "h++", 5);
        a("text/x-c++hdr", "hpp", 5);
        a("text/x-c++hdr", "hxx", 5);
        a("text/x-c++hdr", "hh", 5);
        a("text/x-c++src", "c++", 5);
        a("text/x-c++src", "cpp", 5);
        a("text/x-c++src", "cxx", 5);
        a("text/x-chdr", "h", 5);
        a("text/x-component", "htc", 5);
        a("text/x-csh", "csh", 5);
        a("text/x-csrc", "c", 5);
        a("text/x-dsrc", "d", 5);
        a("text/x-haskell", "hs", 5);
        a("text/x-java", "java", 5);
        a("text/x-literate-haskell", "lhs", 5);
        a("text/x-moc", "moc", 5);
        a("text/x-pascal", "p", 5);
        a("text/x-pascal", "pas", 5);
        a("text/x-pcs-gcd", "gcd", 5);
        a("text/x-setext", "etx", 5);
        a("text/x-tcl", "tcl", 5);
        a("text/x-tex", "tex", 5);
        a("text/x-tex", "ltx", 5);
        a("text/x-tex", "sty", 5);
        a("text/x-tex", "cls", 5);
        a("text/x-vcalendar", "vcs", 5);
        a("text/x-vcard", "vcf", 5);
        a("video/mkv", "mkv", 0);
        a("video/3gpp", "3gpp", 0);
        a("video/3gpp", "3gp", 0);
        a("video/3gpp", "3g2", 0);
        a("video/dl", "dl", 0);
        a("video/dv", "dif", 0);
        a("video/dv", "dv", 0);
        a("video/fli", "fli", 0);
        a("video/m4v", "m4v", 0);
        a("video/mpeg", "mpeg", 0);
        a("video/mpeg", "mpg", 0);
        a("video/mpeg", "mpe", 0);
        a("video/mp4", "mp4", 0);
        a("video/mpeg", "vob", 0);
        a("video/quicktime", "qt", 0);
        a("video/quicktime", "mov", 0);
        a("video/vnd.mpegurl", "mxu", 0);
        a("video/x-la-asf", "lsf", 0);
        a("video/x-la-asf", "lsx", 0);
        a("video/x-mng", "mng", 0);
        a("video/x-ms-asf", "asf", 0);
        a("video/x-ms-asf", "asx", 0);
        a("video/x-ms-wm", "wm", 0);
        a("video/x-ms-wmv", "wmv", 0);
        a("video/x-ms-wmx", "wmx", 0);
        a("video/x-ms-wvx", "wvx", 0);
        a("video/x-msvideo", "avi", 0);
        a("video/x-sgi-movie", "movie", 0);
        a("video/x-webex", "wrf", 0);
        a("x-conference/x-cooltalk", "ice", 5);
        a("x-epoc/x-sisx-app", "sisx", 5);
        a("video/vnd.rn-realvideo", "rmvb", 0);
        a("video/x-flv", "flv", 0);
        a("audio/aac", "aac", 1);
        a("application/vnd.rn-realmedia", "rm", 0);
        a("message/rfc822", "mht", 11);
        Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    }

    public static void a(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, str, str2, i2) == null) {
            f9409c.put(str2, Integer.valueOf(i2));
            f9410d.put(str, Integer.valueOf(i2));
            f9411e.put(str2, str);
            if (f9412f.containsKey(str)) {
                return;
            }
            f9412f.put(str, str2);
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (str == null || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length()) ? "" : str.substring(lastIndexOf + 1) : (String) invokeL.objValue;
    }

    @Nullable
    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return f9412f.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return f9411e.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                Matcher matcher = f9408b.matcher(str);
                if (matcher.find()) {
                    return matcher.group(1);
                }
                return null;
            } catch (IllegalStateException e2) {
                if (f9407a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
