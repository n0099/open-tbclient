package c.a.p0.w2.l;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.v0;
import c.a.p0.l3.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean A;
    public static boolean B;
    public static PbActivityConfig C;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f19899b;

    /* renamed from: c  reason: collision with root package name */
    public static String f19900c;

    /* renamed from: d  reason: collision with root package name */
    public static int f19901d;

    /* renamed from: e  reason: collision with root package name */
    public static String f19902e;

    /* renamed from: f  reason: collision with root package name */
    public static String f19903f;

    /* renamed from: g  reason: collision with root package name */
    public static String f19904g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f19905h;
    public static final BdUniDispatchSchemeController.b i;
    public static int j;
    public static int k;
    public static String l;
    public static String m;
    public static boolean n;
    public static boolean o;
    public static boolean p;
    public static int q;
    public static String r;
    public static String s;
    public static boolean t;
    public static boolean u;
    public static long v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                String unused = b.a = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                String unused2 = b.f19899b = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                String unused3 = b.f19900c = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                int unused4 = b.f19901d = c.a.d.f.m.b.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                String unused5 = b.f19902e = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1095714265, "Lc/a/p0/w2/l/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1095714265, "Lc/a/p0/w2/l/b;");
                return;
            }
        }
        i = new a();
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String str = a;
            String g2 = (str == null || str.equals("0")) ? g() : a;
            if (o) {
                g2 = g2 + "_host";
            }
            int i2 = q;
            if (i2 == 1) {
                g2 = g2 + "_rev";
            } else if (i2 == 2) {
                g2 = g2 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return g2 + TbadkCoreApplication.getCurrentAccount();
            }
            return g2;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str = "";
            if (f19899b != null) {
                str = "" + f19899b;
            }
            if (f19900c != null) {
                str = str + f19900c;
            }
            String str2 = str + f19901d;
            if (f19902e != null) {
                return str2 + f19902e;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public static HashMap<String, Object> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            String[] split = str.split("[&]");
            if (split.length == 0) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void i(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, intent) == null) {
            a = intent.getStringExtra("thread_id");
            f19899b = intent.getStringExtra("key_ori_ugc_nid");
            f19900c = intent.getStringExtra("key_ori_ugc_tid");
            f19901d = intent.getIntExtra("key_ori_ugc_type", 0);
            f19902e = intent.getStringExtra("key_ori_ugc_vid");
            intent.getBooleanExtra("key_jump_to_comment_area", false);
            intent.getBooleanExtra("is_jump_from_video_middle", false);
            f19903f = intent.getStringExtra("key_official_bar_message_id");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            f19904g = uri != null ? uri.toString() : null;
            f19905h = false;
            if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                f19905h = true;
                BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, i);
            } else if (StringUtils.isNull(a)) {
                f19905h = true;
                String uri2 = uri != null ? uri.toString() : "";
                if (!StringUtils.isNull(uri2) && uri2.startsWith("tbpb://")) {
                    if (uri == null) {
                        return;
                    }
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (StringUtils.isNull(decode) || h(decode) == null) {
                        return;
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                    httpMessage.addParam("call_url", uri2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
                if (uri != null) {
                    if (StringUtils.isNull(a)) {
                        a = uri.getQueryParameter("thread_id");
                    }
                    if (StringUtils.isNull(f19899b)) {
                        f19899b = uri.getQueryParameter("key_ori_ugc_nid");
                    }
                    if (StringUtils.isNull(f19900c)) {
                        f19900c = uri.getQueryParameter("key_ori_ugc_tid");
                    }
                    if (f19901d == 0) {
                        f19901d = c.a.d.f.m.b.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                    }
                    if (StringUtils.isNull(f19902e)) {
                        f19902e = uri.getQueryParameter("key_ori_ugc_vid");
                    }
                }
            }
            if (m.isEmpty(a)) {
                a = "0";
            }
            int intExtra = intent.getIntExtra("key_start_from", 0);
            j = intExtra;
            if (intExtra == 0) {
                j = k;
            }
            l = intent.getStringExtra("post_id");
            m = intent.getStringExtra("forum_id");
            n = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            o = intent.getBooleanExtra("host_only", false);
            p = intent.getBooleanExtra("squence", true);
            int intExtra2 = intent.getIntExtra("sort_type", -1);
            q = intExtra2;
            if (intExtra2 < 0) {
                intExtra2 = c.a.o0.r.j0.b.k().l("key_pb_current_sort_type", 2);
            }
            q = intExtra2;
            l = intExtra2 != 2 ? l : "0";
            r = intent.getStringExtra("st_type");
            s = intent.getStringExtra("locate");
            t = intent.getBooleanExtra("from_mark", false);
            u = intent.getBooleanExtra("is_pv", false);
            v = intent.getLongExtra("msg_id", 0L);
            w = intent.getStringExtra("from_forum_name");
            x = intent.getStringExtra("op_type");
            y = intent.getStringExtra("op_url");
            z = intent.getStringExtra("op_stat");
            A = intent.getBooleanExtra("from_smart_frs", false);
            B = intent.getIntExtra("request_code", -1) == 18003;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x015a, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int j(String[] strArr) {
        InterceptResult invokeL;
        String c2;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        String substring;
        PbActivityConfig createNormalCfg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, strArr)) == null) {
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                return 3;
            }
            Pattern compile = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
            String lowerCase = strArr[0].toLowerCase();
            Matcher matcher = compile.matcher(lowerCase);
            String str2 = "push";
            if (Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() || lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_BAIJIAHAO_PB)) {
                return 3;
            }
            String str3 = "allthread";
            String str4 = "";
            if (matcher.find()) {
                c2 = matcher.group(1);
                Uri parse = Uri.parse(lowerCase);
                str4 = parse.getQueryParameter("pid");
                z3 = c.a.d.f.m.b.b(parse.getQueryParameter("is_video"), false);
                z5 = c.a.d.f.m.b.b(parse.getQueryParameter("is_official_video"), false);
                str = parse.getQueryParameter("broadcast_id");
                if (lowerCase != null) {
                    String[] split = lowerCase.split("&");
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (split[i2] != null) {
                            if (split[i2].startsWith("thread_type=")) {
                                split[i2].substring(12);
                            } else if (split[i2].startsWith("playstatkey=")) {
                                str2 = split[i2].substring(12);
                            }
                        }
                    }
                    z2 = c.a.d.f.m.b.b(v0.c(lowerCase, "is_from_push="), false);
                } else {
                    z2 = false;
                }
                if (lowerCase != null && lowerCase.contains("?")) {
                    String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                    int length = split2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        String str5 = split2[i3];
                        if (str5.startsWith("playstatkey=")) {
                            str2 = str5.substring(12);
                            break;
                        }
                        i3++;
                    }
                }
                if (lowerCase != null) {
                    String c3 = v0.c(lowerCase, "sttype=");
                    if (!StringUtils.isNull(c3)) {
                        str3 = c3;
                    }
                }
                z4 = true;
            } else {
                if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
                    if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                        substring = lowerCase.substring(25);
                    } else {
                        substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring(25) : null;
                    }
                    if (substring != null) {
                        String[] split3 = substring.split("&");
                        int i4 = 0;
                        while (true) {
                            if (i4 >= split3.length) {
                                c2 = null;
                                break;
                            } else if (split3[i4] != null && split3[i4].startsWith("kz=")) {
                                c2 = split3[i4].substring(3);
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (!TextUtils.isEmpty(c2) && c2.contains("&")) {
                            c2 = c2.split("&")[0];
                        }
                    }
                    c2 = null;
                } else {
                    if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                        String substring2 = lowerCase.substring(3);
                        if (strArr.length > 1) {
                            str3 = strArr[1];
                            c2 = substring2;
                        } else {
                            c2 = substring2;
                        }
                    } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                        c2 = lowerCase.substring(22);
                    } else if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kz=")) {
                        return 3;
                    } else {
                        c2 = v0.c(lowerCase, "kz=");
                    }
                    z2 = false;
                    str = null;
                    z3 = false;
                    str3 = null;
                    z4 = true;
                    z5 = false;
                }
                z2 = false;
                str = null;
                z3 = false;
                z4 = true;
                z5 = false;
            }
            if (StringUtils.isNull(c2, z4) || z3 || z5) {
                return 3;
            }
            if (StringUtils.isNull(str4)) {
                createNormalCfg = new PbActivityConfig(TbadkCoreApplication.getInst()).createNormalCfg(c2, null, str3);
            } else {
                createNormalCfg = new PbActivityConfig(TbadkCoreApplication.getInst()).createNormalCfg(c2, str4, str3);
            }
            if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(v0.c(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                createNormalCfg.setUserName(v0.c(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
            }
            createNormalCfg.setVideo_source(str2);
            createNormalCfg.setStartFrom(25);
            if (z2) {
                createNormalCfg.setFromPushNotify();
                createNormalCfg.setStartFrom(7);
            }
            if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                createNormalCfg.setStartFrom(7);
            }
            if (!StringUtils.isNull(str)) {
                createNormalCfg.setOfficialBarMessageId(str);
            }
            if (lowerCase != null && lowerCase.contains("fr=collect")) {
                createNormalCfg.setJumpToCommentArea(true);
            }
            C = createNormalCfg;
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x012e A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0132 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0172 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017a A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018d A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0194 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d1 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:103:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(3);
            pbPageRequestMessage.setIsReqAd(1);
            pbPageRequestMessage.setLastids(c.a.o0.u.a.o);
            if (o || t) {
                B = false;
            }
            try {
                if (a != null && a.length() != 0) {
                    pbPageRequestMessage.set_kz(c.a.d.f.m.b.g(a, 0L));
                    pbPageRequestMessage.setFloorSortType(1);
                    pbPageRequestMessage.setFloor_rn(4);
                    pbPageRequestMessage.set_rn(15);
                    pbPageRequestMessage.set_with_floor(1);
                    pbPageRequestMessage.set_scr_w(Integer.valueOf(n.k(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_h(Integer.valueOf(n.i(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                    pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                    pbPageRequestMessage.setSchemeUrl(f19904g);
                    if (!p) {
                        pbPageRequestMessage.set_r(1);
                    }
                    pbPageRequestMessage.set_r(Integer.valueOf(q));
                    if (o) {
                        pbPageRequestMessage.set_lz(1);
                    }
                    if (r != null) {
                        pbPageRequestMessage.set_st_type(r);
                    }
                    if (s != null) {
                        pbPageRequestMessage.setLocate(s);
                    }
                    if (u) {
                        pbPageRequestMessage.set_message_id(Integer.valueOf((int) v));
                        pbPageRequestMessage.set_message_click("1");
                    }
                    if (B) {
                        pbPageRequestMessage.set_banner(1);
                    }
                    if (x != null) {
                        pbPageRequestMessage.setOpType(x);
                        pbPageRequestMessage.setOpUrl(y);
                        pbPageRequestMessage.setOpStat(c.a.d.f.m.b.e(z, 0));
                        pbPageRequestMessage.setOpMessageID(v);
                    }
                    pbPageRequestMessage.set_thread_type(0);
                    if (!t && !o) {
                        pbPageRequestMessage.set_banner(1);
                        pbPageRequestMessage.set_back(0);
                        if (q != 0 && q != 2) {
                            z2 = false;
                            if (!z2) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                pbPageRequestMessage.set_pn(1);
                            }
                            if (t) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            n(pbPageRequestMessage);
                            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                            pbPageRequestMessage.setCacheKey(f());
                            pbPageRequestMessage.setObjParam1(String.valueOf(j));
                            pbPageRequestMessage.setIsSubPostDataReverse(false);
                            pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                            if (!UtilHelper.isUgcThreadType(f19901d)) {
                                pbPageRequestMessage.setForumId(String.valueOf(0));
                            } else {
                                pbPageRequestMessage.setForumId(m);
                            }
                            pbPageRequestMessage.setNeedRepostRecommendForum(n);
                            if (j != 7) {
                                pbPageRequestMessage.setFrom_push(1);
                            } else {
                                pbPageRequestMessage.setFrom_push(0);
                            }
                            if (j != 7 && j != 5 && !f19905h) {
                                pbPageRequestMessage.setSourceType(2);
                                pbPageRequestMessage.setOriUgcNid(f19899b);
                                pbPageRequestMessage.setOriUgcTid(f19900c);
                                pbPageRequestMessage.setOriUgcType(f19901d);
                                pbPageRequestMessage.setOriUgcVid(f19902e);
                                if (!StringUtils.isNull(f19903f)) {
                                    pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(f19903f));
                                }
                                int i2 = -1;
                                if (pbPageRequestMessage.getPn() != null) {
                                    if (pbPageRequestMessage.getR().intValue() == 1) {
                                        if (pbPageRequestMessage.getPn().intValue() == 1) {
                                            pbPageRequestMessage.setAfterAdThreadCount(i2);
                                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                            pbPageRequestMessage.setReqFoldComment(false);
                                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                            pbPageRequestMessage.setFromPbOptimize(true);
                                            c.a.p0.w2.l.a.a().e(true);
                                            MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                                        }
                                    } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                                        pbPageRequestMessage.setAfterAdThreadCount(i2);
                                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                        pbPageRequestMessage.setReqFoldComment(false);
                                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                        pbPageRequestMessage.setFromPbOptimize(true);
                                        c.a.p0.w2.l.a.a().e(true);
                                        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                                    }
                                }
                                i2 = 0;
                                pbPageRequestMessage.setAfterAdThreadCount(i2);
                                pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                pbPageRequestMessage.setReqFoldComment(false);
                                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                pbPageRequestMessage.setFromPbOptimize(true);
                                c.a.p0.w2.l.a.a().e(true);
                                MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                            }
                            pbPageRequestMessage.setSourceType(1);
                            pbPageRequestMessage.setOriUgcNid(f19899b);
                            pbPageRequestMessage.setOriUgcTid(f19900c);
                            pbPageRequestMessage.setOriUgcType(f19901d);
                            pbPageRequestMessage.setOriUgcVid(f19902e);
                            if (!StringUtils.isNull(f19903f)) {
                            }
                            int i22 = -1;
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i22 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i22);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            c.a.p0.w2.l.a.a().e(true);
                            MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        if (t) {
                        }
                        n(pbPageRequestMessage);
                        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                        pbPageRequestMessage.setCacheKey(f());
                        pbPageRequestMessage.setObjParam1(String.valueOf(j));
                        pbPageRequestMessage.setIsSubPostDataReverse(false);
                        pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                        if (!UtilHelper.isUgcThreadType(f19901d)) {
                        }
                        pbPageRequestMessage.setNeedRepostRecommendForum(n);
                        if (j != 7) {
                        }
                        if (j != 7) {
                            pbPageRequestMessage.setSourceType(2);
                            pbPageRequestMessage.setOriUgcNid(f19899b);
                            pbPageRequestMessage.setOriUgcTid(f19900c);
                            pbPageRequestMessage.setOriUgcType(f19901d);
                            pbPageRequestMessage.setOriUgcVid(f19902e);
                            if (!StringUtils.isNull(f19903f)) {
                            }
                            int i222 = -1;
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i222 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i222);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            c.a.p0.w2.l.a.a().e(true);
                            MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                        }
                        pbPageRequestMessage.setSourceType(1);
                        pbPageRequestMessage.setOriUgcNid(f19899b);
                        pbPageRequestMessage.setOriUgcTid(f19900c);
                        pbPageRequestMessage.setOriUgcType(f19901d);
                        pbPageRequestMessage.setOriUgcVid(f19902e);
                        if (!StringUtils.isNull(f19903f)) {
                        }
                        int i2222 = -1;
                        if (pbPageRequestMessage.getPn() != null) {
                        }
                        i2222 = 0;
                        pbPageRequestMessage.setAfterAdThreadCount(i2222);
                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                        pbPageRequestMessage.setReqFoldComment(false);
                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                        pbPageRequestMessage.setFromPbOptimize(true);
                        c.a.p0.w2.l.a.a().e(true);
                        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                    }
                    pbPageRequestMessage.set_banner(0);
                    pbPageRequestMessage.set_back(0);
                    if (q != 0) {
                        z2 = false;
                        if (!z2) {
                        }
                        if (t) {
                        }
                        n(pbPageRequestMessage);
                        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                        pbPageRequestMessage.setCacheKey(f());
                        pbPageRequestMessage.setObjParam1(String.valueOf(j));
                        pbPageRequestMessage.setIsSubPostDataReverse(false);
                        pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                        if (!UtilHelper.isUgcThreadType(f19901d)) {
                        }
                        pbPageRequestMessage.setNeedRepostRecommendForum(n);
                        if (j != 7) {
                        }
                        if (j != 7) {
                        }
                        pbPageRequestMessage.setSourceType(1);
                        pbPageRequestMessage.setOriUgcNid(f19899b);
                        pbPageRequestMessage.setOriUgcTid(f19900c);
                        pbPageRequestMessage.setOriUgcType(f19901d);
                        pbPageRequestMessage.setOriUgcVid(f19902e);
                        if (!StringUtils.isNull(f19903f)) {
                        }
                        int i22222 = -1;
                        if (pbPageRequestMessage.getPn() != null) {
                        }
                        i22222 = 0;
                        pbPageRequestMessage.setAfterAdThreadCount(i22222);
                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                        pbPageRequestMessage.setReqFoldComment(false);
                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                        pbPageRequestMessage.setFromPbOptimize(true);
                        c.a.p0.w2.l.a.a().e(true);
                        MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    if (t) {
                    }
                    n(pbPageRequestMessage);
                    pbPageRequestMessage.setIsFromMark(Boolean.valueOf(t));
                    pbPageRequestMessage.setCacheKey(f());
                    pbPageRequestMessage.setObjParam1(String.valueOf(j));
                    pbPageRequestMessage.setIsSubPostDataReverse(false);
                    pbPageRequestMessage.setFromSmartFrs(!A ? 1 : 0);
                    if (!UtilHelper.isUgcThreadType(f19901d)) {
                    }
                    pbPageRequestMessage.setNeedRepostRecommendForum(n);
                    if (j != 7) {
                    }
                    if (j != 7) {
                    }
                    pbPageRequestMessage.setSourceType(1);
                    pbPageRequestMessage.setOriUgcNid(f19899b);
                    pbPageRequestMessage.setOriUgcTid(f19900c);
                    pbPageRequestMessage.setOriUgcType(f19901d);
                    pbPageRequestMessage.setOriUgcVid(f19902e);
                    if (!StringUtils.isNull(f19903f)) {
                    }
                    int i222222 = -1;
                    if (pbPageRequestMessage.getPn() != null) {
                    }
                    i222222 = 0;
                    pbPageRequestMessage.setAfterAdThreadCount(i222222);
                    pbPageRequestMessage.setImmersionVideoCommentSource(0);
                    pbPageRequestMessage.setReqFoldComment(false);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    pbPageRequestMessage.setFromPbOptimize(true);
                    c.a.p0.w2.l.a.a().e(true);
                    MessageManager.getInstance().sendMessage(pbPageRequestMessage);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public static void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, intent) == null) || intent == null) {
            return;
        }
        i(intent);
        k();
    }

    public static void m(String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, strArr) == null) && j(strArr) == 0) {
            i(C.getIntent());
            k();
        }
    }

    public static void n(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, pbPageRequestMessage) == null) || TextUtils.isEmpty(w) || z.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(z.q().b().d(w, true) + 1);
        pbPageRequestMessage.setLoadCount(z.q().b().e(w, true));
    }
}
