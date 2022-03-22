package c.a.n0.h.b.f;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public GamenowDownloadButtomView a;

    /* renamed from: b  reason: collision with root package name */
    public j f8432b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.h.a.c.f.a f8433c;

    /* renamed from: d  reason: collision with root package name */
    public GameGuideConfigInfo.CloseInfo f8434d;

    /* renamed from: e  reason: collision with root package name */
    public String f8435e;

    /* renamed from: f  reason: collision with root package name */
    public String f8436f;

    /* renamed from: g  reason: collision with root package name */
    public String f8437g;

    /* renamed from: h  reason: collision with root package name */
    public String f8438h;
    public String i;
    public String j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.a.f8438h.equals("wdview")) {
                    if (this.a.f8438h.equals("gbview") && this.a.f8434d != null) {
                        if (this.a.f8434d.type != 0 && this.a.f8434d.type != 1) {
                            if (this.a.f8434d.type == 2) {
                                c.a.n0.h.b.j.b.n().b("gbADialogClick", "0", "", "");
                            }
                        } else {
                            c.a.n0.h.b.j.b.n().b("gbBDialogClick", "0", "", "");
                        }
                    }
                } else {
                    c.a.n0.h.b.j.b.n().j("0", this.a.k, this.a.l);
                }
                this.a.s(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1609315614, "Lc/a/n0/h/b/f/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1609315614, "Lc/a/n0/h/b/f/c$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DownloadState.NOT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: c.a.n0.h.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0669c extends c.a.n0.a.o1.a.b.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f8439c;

        /* renamed from: d  reason: collision with root package name */
        public String f8440d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.n0.h.a.c.f.a f8441e;

        /* renamed from: f  reason: collision with root package name */
        public String f8442f;

        /* renamed from: g  reason: collision with root package name */
        public String f8443g;

        public C0669c(String str, String str2, c.a.n0.h.a.c.f.a aVar, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, aVar, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8440d = str;
            this.f8439c = str2;
            this.f8441e = aVar;
            this.f8442f = str3;
            this.f8443g = str4;
        }

        @Override // c.a.n0.a.o1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // c.a.n0.a.o1.a.b.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.o1.a.b.c.c, c.a.n0.a.o1.a.b.c.a
        public void onEvent(@NonNull c.a.n0.a.o1.a.b.a.b bVar) {
            Bundle a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a = bVar.a()) == null) {
                return;
            }
            c.q(a, this.f8441e, this.f8440d, this.f8439c, this.f8442f, this.f8443g);
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1609315676, "Lc/a/n0/h/b/f/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1609315676, "Lc/a/n0/h/b/f/c$d;");
                    return;
                }
            }
            a = new c();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1937988004, "Lc/a/n0/h/b/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1937988004, "Lc/a/n0/h/b/f/c;");
                return;
            }
        }
        r = c.a.n0.a.a.a;
        s = 0;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8435e = "";
        this.f8436f = "";
        this.f8437g = "";
        this.j = "";
        this.n = "";
        this.o = "";
        this.p = "";
    }

    public static String f(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, map)) == null) {
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (!TextUtils.isEmpty(map.get(str2))) {
                        str = c.a.n0.w.i.a(str, str2, map.get(str2));
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void g(String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i)}) == null) && TextUtils.equals(c.a.n0.h.b.e.c.a, str) && TextUtils.equals(str2, "checkPackageExpired")) {
            c.a.n0.h.b.j.b.n().m(str3, str4, i);
        }
    }

    public static c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.a : (c) invokeV.objValue;
    }

    public static void q(@NonNull Bundle bundle, c.a.n0.h.a.c.f.a aVar, String str, String str2, String str3, String str4) {
        String string;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{bundle, aVar, str, str2, str3, str4}) == null) || (string = bundle.getString("functionType")) == null || aVar == null) {
            return;
        }
        String string2 = bundle.getString("resultData", "");
        if (r) {
            Log.d("DownloadButtonManager", "handleResult:function = " + string + ",result = " + string2);
        }
        int hashCode = string.hashCode();
        if (hashCode != -1013362275) {
            if (hashCode == -530890460 && string.equals("onSuccess")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (string.equals("onFail")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return;
            }
            if (!TextUtils.isEmpty(string2) && string2.equals(DownloadState.NOT_START.name())) {
                aVar.c(DownloadState.NOT_START, 0);
            }
            g(str, str2, str3, str4, 0);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int optInt = jSONObject.optInt("progress", -1);
            if (optInt > -1) {
                aVar.a(optInt);
            }
            if (jSONObject.optBoolean("installed")) {
                aVar.c(DownloadState.INSTALLED, optInt);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            int optInt2 = optJSONObject.optInt("status", 0);
            int value = DownloadState.NOT_START.value();
            if (optInt2 == 0) {
                aVar.c(DownloadState.DOWNLOADING, optInt);
                value = DownloadState.DOWNLOADING.value();
            } else if (optInt2 == 1) {
                aVar.c(DownloadState.DOWNLOADING, optInt);
                value = DownloadState.DOWNLOADING.value();
            } else if (optInt2 == 2) {
                aVar.c(DownloadState.DOWNLOAD_PAUSED, optInt);
                value = DownloadState.DOWNLOAD_PAUSED.value();
            } else if (optInt2 == 3) {
                aVar.c(DownloadState.DOWNLOAD_FAILED, optInt);
                value = DownloadState.DOWNLOAD_FAILED.value();
            } else if (optInt2 == 4) {
                aVar.c(DownloadState.DELETED, optInt);
                value = DownloadState.DELETED.value();
            } else if (optInt2 == 5) {
                aVar.c(DownloadState.DOWNLOADED, optInt);
                value = DownloadState.DOWNLOADED.value();
            }
            g(str, str2, str3, str4, value);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void A(String str, String str2, String str3, int i) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048576, this, str, str2, str3, i) == null) || (jVar = this.f8432b) == null) {
            return;
        }
        DownloadState downloadState = jVar.a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            String str4 = this.o;
            if (TextUtils.equals(c.a.n0.h.b.e.c.a, this.f8432b.f8461c)) {
                str4 = k(1, str, str2, str3);
                if (!TextUtils.isEmpty(this.q)) {
                    this.f8432b.c(this.q);
                }
            }
            this.f8432b.f8460b = str4;
            this.f8436f = str;
            if (i >= 0) {
                this.f8437g = String.valueOf(i);
            }
        }
        s(false);
    }

    public final void B() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jVar = this.f8432b) == null) {
            return;
        }
        int i = b.a[jVar.a.ordinal()];
        if (i == 1 || i == 2) {
            this.a.j(c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060392));
            this.a.h(c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060392));
            this.a.i(c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060396));
        } else if (i != 3) {
            this.a.j(-1);
            this.a.h(c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060392));
            this.a.i(c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060396));
        } else {
            this.a.j(-1);
            this.a.i(c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060395));
        }
    }

    public final void C(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f8432b) == null) {
            return;
        }
        jVar.f8461c = str;
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            y(i);
        }
    }

    public void E(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadState) == null) {
            z(downloadState);
        }
    }

    public final void F() {
        j jVar;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jVar = this.f8432b) == null) {
            return;
        }
        if (jVar.a == DownloadState.DOWNLOADING) {
            GamenowDownloadButtomView gamenowDownloadButtomView = this.a;
            if (gamenowDownloadButtomView != null && gamenowDownloadButtomView.getVisibility() != 8) {
                if (this.f8432b.f8462d < this.a.getMax()) {
                    String string2 = c.a.n0.a.s0.a.c().getResources().getString(R.string.obfuscated_res_0x7f0f0158);
                    string = String.format(string2, this.f8432b.f8462d + "%");
                } else {
                    string = c.a.n0.a.s0.a.c().getResources().getString(R.string.obfuscated_res_0x7f0f0162);
                }
                this.a.setText(string);
                this.a.setProgress(this.f8432b.f8462d);
            }
        } else {
            String string3 = c.a.n0.a.s0.a.c().getResources().getString(v(this.f8432b.a));
            if (this.f8432b.a == DownloadState.DOWNLOADED) {
                this.a.setProgress(100);
            }
            j jVar2 = this.f8432b;
            if (jVar2.a == DownloadState.DOWNLOAD_PAUSED) {
                this.a.setProgress(jVar2.f8462d);
            }
            this.a.setText(string3);
            DownloadState downloadState = this.f8432b.a;
            if ((downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) && !TextUtils.isEmpty(this.f8435e)) {
                this.a.setText(this.f8435e);
            }
        }
        if (this.a != null) {
            B();
            this.a.setState(this.f8432b.a);
            this.a.postInvalidate();
        }
    }

    public final byte[] h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return Base64Encoder.B64Encode(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public GamenowDownloadButtomView i(c.a.n0.h.a.c.f.a aVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, aVar, str, str2)) == null) ? j(aVar, str, str2, 0, 0) : (GamenowDownloadButtomView) invokeLLL.objValue;
    }

    public GamenowDownloadButtomView j(c.a.n0.h.a.c.f.a aVar, String str, String str2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{aVar, str, str2, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.f8438h = str;
            this.i = str2;
            this.k = i;
            this.l = i2;
            GameGuideConfigInfo z = c.a.n0.h.b.b.o.z();
            int color = c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060392);
            int color2 = c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060aa1);
            if (z != null) {
                this.j = z.configName;
                this.o = z.targetAppDownloadUrl;
                String str3 = z.targetAppPackageId;
                this.p = str3;
                if (TextUtils.equals(c.a.n0.h.b.e.c.a, str3)) {
                    this.q = z.gamenowApkId;
                }
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1252040192) {
                    if (hashCode == -792126734 && str.equals("wdview")) {
                        c2 = 0;
                    }
                } else if (str.equals("gbview")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    GameGuideConfigInfo.DialogInfo dialogInfo = z.dialogInfo;
                    if (dialogInfo != null) {
                        this.f8435e = dialogInfo.buttonText;
                        this.m = dialogInfo.targetType;
                        this.n = dialogInfo.target;
                    }
                } else if (c2 == 1) {
                    GameGuideConfigInfo.CloseInfo closeInfo = z.closeInfo;
                    this.f8434d = closeInfo;
                    if (closeInfo != null) {
                        try {
                            if (!TextUtils.isEmpty(closeInfo.downloadBackgroundColor) && !this.f8434d.downloadBackgroundColor.equals(StringUtil.NULL_STRING)) {
                                color = Color.parseColor(this.f8434d.downloadBackgroundColor);
                            }
                            if (!TextUtils.isEmpty(this.f8434d.downloadTextColor) && !this.f8434d.downloadTextColor.equals(StringUtil.NULL_STRING)) {
                                color2 = Color.parseColor(this.f8434d.downloadTextColor);
                            }
                        } catch (IllegalArgumentException e2) {
                            if (r) {
                                e2.printStackTrace();
                            }
                        }
                        GameGuideConfigInfo.CloseInfo closeInfo2 = this.f8434d;
                        this.f8435e = closeInfo2.buttonText;
                        this.m = closeInfo2.targetType;
                        this.n = closeInfo2.target;
                    }
                }
            }
            String str4 = this.o;
            if (TextUtils.equals(c.a.n0.h.b.e.c.a, this.p)) {
                str4 = k(this.m, this.n, "", "");
            }
            this.f8432b = j.a(str4, this.p);
            if (!TextUtils.isEmpty(this.q)) {
                this.f8432b.c(this.q);
            }
            this.f8433c = aVar;
            GamenowDownloadButtomView gamenowDownloadButtomView = new GamenowDownloadButtomView(c.a.n0.a.s0.a.c());
            this.a = gamenowDownloadButtomView;
            gamenowDownloadButtomView.k(n0.g(16.0f));
            gamenowDownloadButtomView.f(true);
            gamenowDownloadButtomView.j(color2);
            gamenowDownloadButtomView.h(color);
            gamenowDownloadButtomView.i(c.a.n0.a.s0.a.c().getResources().getColor(R.color.obfuscated_res_0x7f060396));
            gamenowDownloadButtomView.g(true);
            this.a.setText(this.f8435e);
            this.a.setVisibility(0);
            this.a.setProgress(s);
            this.a.setState(DownloadState.NOT_START);
            r();
            t();
            return this.a;
        }
        return (GamenowDownloadButtomView) invokeCommon.objValue;
    }

    public final String k(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            String str4 = TextUtils.isEmpty(this.o) ? "https://gamenow.baidu.com/api/download/newest_gamenow" : this.o;
            this.o = str4;
            if (i == 0) {
                return str4;
            }
            String i2 = c.a.n0.a.s0.a.h0().i(AppRuntime.getAppContext());
            int J = c.a.n0.h.b.b.o.J();
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(i2)) {
                stringBuffer.append(i2);
            }
            stringBuffer.append(",");
            stringBuffer.append(J);
            if (i == 1) {
                if (TextUtils.isEmpty(str) || str.equals(StringUtil.NULL_STRING)) {
                    str = c.a.n0.a.t1.d.J().getAppId();
                }
                stringBuffer.append(",");
                stringBuffer.append(str);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    stringBuffer.append(",");
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                    stringBuffer.append(str3);
                }
            }
            str = (i != 2 || TextUtils.isEmpty(str)) ? "" : "";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ext", new String(h(stringBuffer.toString().getBytes())));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, str);
                }
                jSONObject.put("path", "operate");
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.n0.h.b.b bVar = c.a.n0.h.b.b.o;
            String str5 = (bVar == null || bVar.z() == null || TextUtils.isEmpty(c.a.n0.h.b.b.o.z().gamenowChannel)) ? "2101000000" : c.a.n0.h.b.b.o.z().gamenowChannel;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str6 = new String(h(jSONObject.toString().getBytes()));
            linkedHashMap.put("channel", str5);
            linkedHashMap.put("suffix", str6);
            linkedHashMap.put(BreakpointSQLiteKey.FILENAME, "");
            String f2 = f(this.o, linkedHashMap);
            if (!TextUtils.isEmpty(f2)) {
                f2 = c.a.n0.a.s0.a.o().m(f2);
            }
            if (r) {
                Log.e("DownloadButtonManager", "channel is " + str5);
                Log.e("DownloadButtonManager", "ext is " + stringBuffer.toString());
                Log.e("DownloadButtonManager", "suffixObj is " + jSONObject.toString());
                Log.e("DownloadButtonManager", "downloadUrl is " + f2);
            }
            return f2;
        }
        return (String) invokeCommon.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f8436f : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f8437g : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f8432b.f8460b : (String) invokeV.objValue;
    }

    public final void p(String str, c.a.n0.h.a.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, aVar) == null) || this.f8432b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", this.f8432b.f8461c);
            jSONObject.put("key_download_url", this.f8432b.f8460b);
            jSONObject2.put("from_view", this.f8438h);
            jSONObject2.put("from_value", this.i);
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.j);
            jSONObject2.put("apk_id", this.f8432b.b());
            jSONObject.put("download_params", jSONObject2.toString());
            if (TextUtils.equals(str, "checkPackageExpired")) {
                jSONObject.put(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, c.a.n0.h.b.b.o.z() == null ? 0L : c.a.n0.h.b.b.o.z().packageExpire);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString("operation", str);
        bundle.putString("ubc_params", new c.a.n0.h.b.j.a().a());
        bundle.putString("data", jSONObject.toString());
        c.a.n0.a.o1.c.e.a z = c.a.n0.a.t1.d.J().z();
        if (z != null) {
            z.W(bundle, f.class, new C0669c(this.f8432b.f8461c, str, aVar, this.f8438h, this.i));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.setOnClickListener(new a(this));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                Toast.makeText(c.a.n0.a.s0.a.c(), c.a.n0.a.s0.a.c().getResources().getString(R.string.obfuscated_res_0x7f0f0180), 0).show();
                return;
            }
            j jVar = this.f8432b;
            if (jVar == null) {
                return;
            }
            DownloadState downloadState = jVar.a;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download start");
                }
                p("startDownload", this.f8433c);
            }
            if (this.f8432b.a == DownloadState.DOWNLOADING && z) {
                if (r) {
                    Log.d("DownloadButtonManager", "download pause");
                }
                p("pauseDownload", this.f8433c);
            }
            if (this.f8432b.a == DownloadState.DOWNLOAD_PAUSED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download resume");
                }
                p("resumeDownload", this.f8433c);
            }
            if (this.f8432b.a == DownloadState.DOWNLOAD_FAILED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download retry");
                }
                p("startDownload", this.f8433c);
            }
            if (this.f8432b.a == DownloadState.DOWNLOADED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download install");
                }
                this.f8433c.b();
                p("installApp", this.f8433c);
            }
            if (this.f8432b.a == DownloadState.INSTALLED) {
                if (r) {
                    Log.d("DownloadButtonManager", "open app");
                }
                String e2 = this.f8433c.e();
                if (TextUtils.isEmpty(this.f8432b.f8461c) && !TextUtils.isEmpty(e2)) {
                    C(e2);
                }
                p("open_manual", this.f8433c);
            }
        }
    }

    public void t() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (jVar = this.f8432b) == null || TextUtils.isEmpty(jVar.f8461c) || TextUtils.isEmpty(this.p) || this.f8433c == null) {
            return;
        }
        if (q0.F(c.a.n0.a.s0.a.c(), this.f8432b.f8461c)) {
            E(DownloadState.INSTALLED);
            g(this.p, "checkPackageExpired", this.f8438h, this.i, DownloadState.INSTALLED.value());
            return;
        }
        p("checkPackageExpired", this.f8433c);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f8433c = null;
            this.a = null;
            this.f8432b = null;
        }
    }

    public final int v(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, downloadState)) == null) {
            switch (b.a[downloadState.ordinal()]) {
                case 1:
                    return R.string.obfuscated_res_0x7f0f0164;
                case 2:
                    return R.string.obfuscated_res_0x7f0f0160;
                case 3:
                    return R.string.obfuscated_res_0x7f0f0162;
                case 4:
                default:
                    return R.string.obfuscated_res_0x7f0f015f;
                case 5:
                    return R.string.obfuscated_res_0x7f0f0161;
                case 6:
                    return R.string.obfuscated_res_0x7f0f0163;
            }
        }
        return invokeL.intValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f8436f = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f8437g = str;
        }
    }

    public final void y(int i) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || (jVar = this.f8432b) == null || i == jVar.f8462d) {
            return;
        }
        jVar.f8462d = i;
        F();
    }

    public final void z(DownloadState downloadState) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, downloadState) == null) || (jVar = this.f8432b) == null || downloadState == jVar.a) {
            return;
        }
        jVar.a = downloadState;
        F();
    }
}
