package c.a.s0.h.j.n;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.k;
import c.a.s0.a.z2.n0;
import c.a.s0.a.z2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public GamenowDownloadButtomView a;

    /* renamed from: b  reason: collision with root package name */
    public j f10854b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.h.i.k.f.a f10855c;

    /* renamed from: d  reason: collision with root package name */
    public GameGuideConfigInfo.CloseInfo f10856d;

    /* renamed from: e  reason: collision with root package name */
    public String f10857e;

    /* renamed from: f  reason: collision with root package name */
    public String f10858f;

    /* renamed from: g  reason: collision with root package name */
    public String f10859g;

    /* renamed from: h  reason: collision with root package name */
    public String f10860h;

    /* renamed from: i  reason: collision with root package name */
    public String f10861i;

    /* renamed from: j  reason: collision with root package name */
    public String f10862j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10863e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10863e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f10863e.f10860h.equals("wdview")) {
                    if (this.f10863e.f10860h.equals("gbview") && this.f10863e.f10856d != null) {
                        if (this.f10863e.f10856d.type != 0 && this.f10863e.f10856d.type != 1) {
                            if (this.f10863e.f10856d.type == 2) {
                                c.a.s0.h.j.r.b.n().b("gbADialogClick", "0", "", "");
                            }
                        } else {
                            c.a.s0.h.j.r.b.n().b("gbBDialogClick", "0", "", "");
                        }
                    }
                } else {
                    c.a.s0.h.j.r.b.n().j("0", this.f10863e.k, this.f10863e.l);
                }
                this.f10863e.s(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1428914579, "Lc/a/s0/h/j/n/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1428914579, "Lc/a/s0/h/j/n/c$b;");
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

    /* renamed from: c.a.s0.h.j.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0730c extends c.a.s0.a.y1.a.b.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f10864c;

        /* renamed from: d  reason: collision with root package name */
        public String f10865d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.s0.h.i.k.f.a f10866e;

        /* renamed from: f  reason: collision with root package name */
        public String f10867f;

        /* renamed from: g  reason: collision with root package name */
        public String f10868g;

        public C0730c(String str, String str2, c.a.s0.h.i.k.f.a aVar, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, aVar, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10865d = str;
            this.f10864c = str2;
            this.f10866e = aVar;
            this.f10867f = str3;
            this.f10868g = str4;
        }

        @Override // c.a.s0.a.y1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // c.a.s0.a.y1.a.b.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.y1.a.b.c.c, c.a.s0.a.y1.a.b.c.a
        public void onEvent(@NonNull c.a.s0.a.y1.a.b.a.b bVar) {
            Bundle a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a = bVar.a()) == null) {
                return;
            }
            c.q(a, this.f10866e, this.f10865d, this.f10864c, this.f10867f, this.f10868g);
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1428914641, "Lc/a/s0/h/j/n/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1428914641, "Lc/a/s0/h/j/n/c$d;");
                    return;
                }
            }
            a = new c();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2103538671, "Lc/a/s0/h/j/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2103538671, "Lc/a/s0/h/j/n/c;");
                return;
            }
        }
        r = k.a;
        s = 0;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10857e = "";
        this.f10858f = "";
        this.f10859g = "";
        this.f10862j = "";
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
                        str = c.a.s0.w.i.a(str, str2, map.get(str2));
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void g(String str, String str2, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2)}) == null) && TextUtils.equals(c.a.s0.h.j.m.c.a, str) && TextUtils.equals(str2, "checkPackageExpired")) {
            c.a.s0.h.j.r.b.n().m(str3, str4, i2);
        }
    }

    public static c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.a : (c) invokeV.objValue;
    }

    public static void q(@NonNull Bundle bundle, c.a.s0.h.i.k.f.a aVar, String str, String str2, String str3, String str4) {
        String string;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{bundle, aVar, str, str2, str3, str4}) == null) || (string = bundle.getString("functionType")) == null || aVar == null) {
            return;
        }
        String string2 = bundle.getString("resultData", "");
        if (r) {
            String str5 = "handleResult:function = " + string + ",result = " + string2;
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

    public void A(String str, String str2, String str3, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048576, this, str, str2, str3, i2) == null) || (jVar = this.f10854b) == null) {
            return;
        }
        DownloadState downloadState = jVar.a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            String str4 = this.o;
            if (TextUtils.equals(c.a.s0.h.j.m.c.a, this.f10854b.f10891c)) {
                str4 = k(1, str, str2, str3);
                if (!TextUtils.isEmpty(this.q)) {
                    this.f10854b.c(this.q);
                }
            }
            this.f10854b.f10890b = str4;
            this.f10858f = str;
            if (i2 >= 0) {
                this.f10859g = String.valueOf(i2);
            }
        }
        s(false);
    }

    public final void B() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jVar = this.f10854b) == null) {
            return;
        }
        int i2 = b.a[jVar.a.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.a.setTextColor(c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_blue_color));
            this.a.setBgColor(c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_blue_color));
            this.a.setFgColor(c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_light_blue_color));
        } else if (i2 != 3) {
            this.a.setTextColor(-1);
            this.a.setBgColor(c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_blue_color));
            this.a.setFgColor(c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_light_blue_color));
        } else {
            this.a.setTextColor(-1);
            this.a.setFgColor(c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_gold_color));
        }
    }

    public final void C(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f10854b) == null) {
            return;
        }
        jVar.f10891c = str;
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            y(i2);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jVar = this.f10854b) == null) {
            return;
        }
        if (jVar.a == DownloadState.DOWNLOADING) {
            GamenowDownloadButtomView gamenowDownloadButtomView = this.a;
            if (gamenowDownloadButtomView != null && gamenowDownloadButtomView.getVisibility() != 8) {
                if (this.f10854b.f10892d < this.a.getMax()) {
                    String string2 = c.a.s0.a.c1.a.c().getResources().getString(c.a.s0.h.j.k.aiapps_game_button_downloading);
                    string = String.format(string2, this.f10854b.f10892d + "%");
                } else {
                    string = c.a.s0.a.c1.a.c().getResources().getString(c.a.s0.h.j.k.aiapps_game_download_button_install);
                }
                this.a.setText(string);
                this.a.setProgress(this.f10854b.f10892d);
            }
        } else {
            String string3 = c.a.s0.a.c1.a.c().getResources().getString(v(this.f10854b.a));
            if (this.f10854b.a == DownloadState.DOWNLOADED) {
                this.a.setProgress(100);
            }
            j jVar2 = this.f10854b;
            if (jVar2.a == DownloadState.DOWNLOAD_PAUSED) {
                this.a.setProgress(jVar2.f10892d);
            }
            this.a.setText(string3);
            DownloadState downloadState = this.f10854b.a;
            if ((downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) && !TextUtils.isEmpty(this.f10857e)) {
                this.a.setText(this.f10857e);
            }
        }
        if (this.a != null) {
            B();
            this.a.setState(this.f10854b.a);
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

    public GamenowDownloadButtomView i(c.a.s0.h.i.k.f.a aVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, aVar, str, str2)) == null) ? j(aVar, str, str2, 0, 0) : (GamenowDownloadButtomView) invokeLLL.objValue;
    }

    public GamenowDownloadButtomView j(c.a.s0.h.i.k.f.a aVar, String str, String str2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{aVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            this.f10860h = str;
            this.f10861i = str2;
            this.k = i2;
            this.l = i3;
            GameGuideConfigInfo z = c.a.s0.h.j.b.o.z();
            int color = c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_blue_color);
            int color2 = c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.swangame_white);
            if (z != null) {
                this.f10862j = z.configName;
                this.o = z.targetAppDownloadUrl;
                String str3 = z.targetAppPackageId;
                this.p = str3;
                if (TextUtils.equals(c.a.s0.h.j.m.c.a, str3)) {
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
                        this.f10857e = dialogInfo.buttonText;
                        this.m = dialogInfo.targetType;
                        this.n = dialogInfo.target;
                    }
                } else if (c2 == 1) {
                    GameGuideConfigInfo.CloseInfo closeInfo = z.closeInfo;
                    this.f10856d = closeInfo;
                    if (closeInfo != null) {
                        try {
                            if (!TextUtils.isEmpty(closeInfo.downloadBackgroundColor) && !this.f10856d.downloadBackgroundColor.equals(StringUtil.NULL_STRING)) {
                                color = Color.parseColor(this.f10856d.downloadBackgroundColor);
                            }
                            if (!TextUtils.isEmpty(this.f10856d.downloadTextColor) && !this.f10856d.downloadTextColor.equals(StringUtil.NULL_STRING)) {
                                color2 = Color.parseColor(this.f10856d.downloadTextColor);
                            }
                        } catch (IllegalArgumentException e2) {
                            if (r) {
                                e2.printStackTrace();
                            }
                        }
                        GameGuideConfigInfo.CloseInfo closeInfo2 = this.f10856d;
                        this.f10857e = closeInfo2.buttonText;
                        this.m = closeInfo2.targetType;
                        this.n = closeInfo2.target;
                    }
                }
            }
            String str4 = this.o;
            if (TextUtils.equals(c.a.s0.h.j.m.c.a, this.p)) {
                str4 = k(this.m, this.n, "", "");
            }
            this.f10854b = j.a(str4, this.p);
            if (!TextUtils.isEmpty(this.q)) {
                this.f10854b.c(this.q);
            }
            this.f10855c = aVar;
            GamenowDownloadButtomView gamenowDownloadButtomView = new GamenowDownloadButtomView(c.a.s0.a.c1.a.c());
            this.a = gamenowDownloadButtomView;
            gamenowDownloadButtomView.setTextSize(n0.g(16.0f)).isCornerRadius(true).setTextColor(color2).setBgColor(color).setFgColor(c.a.s0.a.c1.a.c().getResources().getColor(c.a.s0.h.j.e.aiapps_download_button_light_blue_color)).isShowProgress(true);
            this.a.setText(this.f10857e);
            this.a.setVisibility(0);
            this.a.setProgress(s);
            this.a.setState(DownloadState.NOT_START);
            r();
            t();
            return this.a;
        }
        return (GamenowDownloadButtomView) invokeCommon.objValue;
    }

    public final String k(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            String str4 = TextUtils.isEmpty(this.o) ? "https://gamenow.baidu.com/api/download/newest_gamenow" : this.o;
            this.o = str4;
            if (i2 == 0) {
                return str4;
            }
            String i3 = c.a.s0.a.c1.a.h0().i(AppRuntime.getAppContext());
            int J = c.a.s0.h.j.b.o.J();
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(i3)) {
                stringBuffer.append(i3);
            }
            stringBuffer.append(",");
            stringBuffer.append(J);
            if (i2 == 1) {
                if (TextUtils.isEmpty(str) || str.equals(StringUtil.NULL_STRING)) {
                    str = c.a.s0.a.d2.d.J().getAppId();
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
            str = (i2 != 2 || TextUtils.isEmpty(str)) ? "" : "";
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
            c.a.s0.h.j.b bVar = c.a.s0.h.j.b.o;
            String str5 = (bVar == null || bVar.z() == null || TextUtils.isEmpty(c.a.s0.h.j.b.o.z().gamenowChannel)) ? "2101000000" : c.a.s0.h.j.b.o.z().gamenowChannel;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str6 = new String(h(jSONObject.toString().getBytes()));
            linkedHashMap.put("channel", str5);
            linkedHashMap.put("suffix", str6);
            linkedHashMap.put(BreakpointSQLiteKey.FILENAME, "");
            String f2 = f(this.o, linkedHashMap);
            if (!TextUtils.isEmpty(f2)) {
                f2 = c.a.s0.a.c1.a.o().m(f2);
            }
            if (r) {
                String str7 = "channel is " + str5;
                String str8 = "ext is " + stringBuffer.toString();
                String str9 = "suffixObj is " + jSONObject.toString();
                String str10 = "downloadUrl is " + f2;
            }
            return f2;
        }
        return (String) invokeCommon.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f10858f : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f10859g : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f10854b.f10890b : (String) invokeV.objValue;
    }

    public final void p(String str, c.a.s0.h.i.k.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, aVar) == null) || this.f10854b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", this.f10854b.f10891c);
            jSONObject.put("key_download_url", this.f10854b.f10890b);
            jSONObject2.put("from_view", this.f10860h);
            jSONObject2.put("from_value", this.f10861i);
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.f10862j);
            jSONObject2.put("apk_id", this.f10854b.b());
            jSONObject.put("download_params", jSONObject2.toString());
            if (TextUtils.equals(str, "checkPackageExpired")) {
                jSONObject.put(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, c.a.s0.h.j.b.o.z() == null ? 0L : c.a.s0.h.j.b.o.z().packageExpire);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
        bundle.putString("ubc_params", new c.a.s0.h.j.r.a().a());
        bundle.putString("data", jSONObject.toString());
        c.a.s0.a.y1.c.e.a z = c.a.s0.a.d2.d.J().z();
        if (z != null) {
            z.W(bundle, f.class, new C0730c(this.f10854b.f10891c, str, aVar, this.f10860h, this.f10861i));
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
                Toast.makeText(c.a.s0.a.c1.a.c(), c.a.s0.a.c1.a.c().getResources().getString(c.a.s0.h.j.k.aiapps_gamenow_network_disconnect), 0).show();
                return;
            }
            j jVar = this.f10854b;
            if (jVar == null) {
                return;
            }
            DownloadState downloadState = jVar.a;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                boolean z2 = r;
                p("startDownload", this.f10855c);
            }
            if (this.f10854b.a == DownloadState.DOWNLOADING && z) {
                boolean z3 = r;
                p("pauseDownload", this.f10855c);
            }
            if (this.f10854b.a == DownloadState.DOWNLOAD_PAUSED) {
                boolean z4 = r;
                p("resumeDownload", this.f10855c);
            }
            if (this.f10854b.a == DownloadState.DOWNLOAD_FAILED) {
                boolean z5 = r;
                p("startDownload", this.f10855c);
            }
            if (this.f10854b.a == DownloadState.DOWNLOADED) {
                boolean z6 = r;
                this.f10855c.b();
                p("installApp", this.f10855c);
            }
            if (this.f10854b.a == DownloadState.INSTALLED) {
                boolean z7 = r;
                String e2 = this.f10855c.e();
                if (TextUtils.isEmpty(this.f10854b.f10891c) && !TextUtils.isEmpty(e2)) {
                    C(e2);
                }
                p("open_manual", this.f10855c);
            }
        }
    }

    public void t() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (jVar = this.f10854b) == null || TextUtils.isEmpty(jVar.f10891c) || TextUtils.isEmpty(this.p) || this.f10855c == null) {
            return;
        }
        if (q0.F(c.a.s0.a.c1.a.c(), this.f10854b.f10891c)) {
            E(DownloadState.INSTALLED);
            g(this.p, "checkPackageExpired", this.f10860h, this.f10861i, DownloadState.INSTALLED.value());
            return;
        }
        p("checkPackageExpired", this.f10855c);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f10855c = null;
            this.a = null;
            this.f10854b = null;
        }
    }

    public final int v(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, downloadState)) == null) {
            switch (b.a[downloadState.ordinal()]) {
                case 1:
                    return c.a.s0.h.j.k.aiapps_game_download_button_pause;
                case 2:
                    return c.a.s0.h.j.k.aiapps_game_download_button_continue;
                case 3:
                    return c.a.s0.h.j.k.aiapps_game_download_button_install;
                case 4:
                    return c.a.s0.h.j.k.aiapps_game_download_button;
                case 5:
                    return c.a.s0.h.j.k.aiapps_game_download_button_failed_retry;
                case 6:
                    return c.a.s0.h.j.k.aiapps_game_download_button_open;
                default:
                    return c.a.s0.h.j.k.aiapps_game_download_button;
            }
        }
        return invokeL.intValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f10858f = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f10859g = str;
        }
    }

    public final void y(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (jVar = this.f10854b) == null || i2 == jVar.f10892d) {
            return;
        }
        jVar.f10892d = i2;
        F();
    }

    public final void z(DownloadState downloadState) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, downloadState) == null) || (jVar = this.f10854b) == null || downloadState == jVar.a) {
            return;
        }
        jVar.a = downloadState;
        F();
    }
}
