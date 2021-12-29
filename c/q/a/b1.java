package c.q.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public e3 f31257b;

    /* renamed from: c  reason: collision with root package name */
    public c1 f31258c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31259d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31260e;

    /* renamed from: f  reason: collision with root package name */
    public e4 f31261f;

    /* renamed from: g  reason: collision with root package name */
    public File f31262g;

    /* renamed from: h  reason: collision with root package name */
    public VideoView f31263h;

    /* renamed from: i  reason: collision with root package name */
    public View f31264i;

    /* renamed from: j  reason: collision with root package name */
    public View f31265j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f31266k;

    public b1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31259d = false;
        this.f31260e = false;
        this.f31266k = new u4(this, Looper.getMainLooper());
        this.a = context;
        try {
            m2.c(context, 0.0f);
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_width", 0.0f);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f31257b = new e3(context, str);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f31257b != null) {
                    r0.o(this.f31257b.b(), 401, "");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                File file = new File(r0.e(this.a) + File.separator + "win" + File.separator + r0.D(str) + ".mp4");
                this.f31262g = file;
                if (file == null || !file.exists()) {
                    if (this.f31261f != null && this.f31261f.getStatus() == AsyncTask.Status.RUNNING) {
                        this.f31261f.cancel(true);
                    }
                    e4 e4Var = new e4(this, System.currentTimeMillis(), str);
                    this.f31261f = e4Var;
                    e4Var.execute(str);
                } else if (this.f31258c == null || this.f31260e || this.f31258c == null || !this.f31262g.exists()) {
                } else {
                    y2 a = c3.a(this.a);
                    a.e(new g3(this.f31257b.b()), 201, 0L);
                    a.m();
                    this.f31258c.onLoaded();
                    this.f31259d = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f() {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (file = this.f31262g) == null || TextUtils.isEmpty(file.getPath()) || this.f31263h == null || TextUtils.isEmpty(this.f31262g.getPath())) {
            return;
        }
        this.f31263h.setOnPreparedListener(new q4(this));
        this.f31263h.setVideoPath(this.f31262g.getPath());
        this.f31263h.seekTo(0);
        this.f31263h.requestFocus();
        this.f31263h.start();
        a();
    }

    public void h() {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f31262g != null && !TextUtils.isEmpty(this.f31262g.getPath()) && (file = this.f31262g) != null) {
                    try {
                        File file2 = new File(file.getPath());
                        if (file2.exists() && file2.isFile()) {
                            file2.delete();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.f31263h != null) {
                    this.f31263h.stopPlayback();
                    this.f31263h.setOnCompletionListener(null);
                    this.f31263h.setOnPreparedListener(null);
                    this.f31263h = null;
                }
                if (this.f31266k != null) {
                    this.f31266k.removeCallbacksAndMessages(null);
                    this.f31266k = null;
                }
                if (this.f31261f != null && this.f31261f.getStatus() == AsyncTask.Status.RUNNING) {
                    this.f31261f.cancel(false);
                    this.f31261f = null;
                }
                if (this.f31257b != null) {
                    Info b2 = this.f31257b.b();
                    if (b2 != null) {
                        y2 a = c3.a(this.a);
                        a.b(new g3(b2));
                        a.m();
                    }
                    this.f31257b.a();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public View i() {
        InterceptResult invokeV;
        e3 e3Var;
        Info b2;
        u2 u2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e3 e3Var2 = this.f31257b;
            if ((e3Var2 == null || (u2Var = e3Var2.a) == null || !u2Var.e()) ? false : true) {
                u2 u2Var2 = this.f31257b.a;
                if (((u2Var2 == null || !u2Var2.e()) ? "" : u2Var2.f31472c.getLoad_type()).equals("video")) {
                    View inflate = LayoutInflater.from(this.a).inflate(l1.win_layout_win_draw_video, (ViewGroup) null);
                    this.f31264i = inflate;
                    VideoView videoView = (VideoView) inflate.findViewById(k1.win_ad_video_view);
                    this.f31263h = videoView;
                    videoView.setVisibility(0);
                    this.f31263h.setOnErrorListener(new i4(this));
                    f();
                    ArrayList arrayList = new ArrayList();
                    arrayList.clear();
                    View view = this.f31264i;
                    if (view != null) {
                        View findViewById = view.findViewById(k1.win_layout_draw_ad_card);
                        this.f31265j = findViewById;
                        arrayList.add(findViewById);
                    }
                    if (this.f31264i != null && (e3Var = this.f31257b) != null && (b2 = e3Var.b()) != null) {
                        ((TextView) this.f31264i.findViewById(k1.win_card_app_name)).setText(b2.getTitle());
                        ((TextView) this.f31264i.findViewById(k1.win_card_app_desc)).setText(b2.getDesc());
                        ((TextView) this.f31264i.findViewById(k1.win_card_h5_open_btn)).setText(b2.getBtndesc());
                        ImageView imageView = (ImageView) this.f31264i.findViewById(k1.win_card_app_icon);
                        String icon = b2.getIcon();
                        if (!TextUtils.isEmpty(icon)) {
                            new f4(new y4(this, imageView)).a(icon, false);
                        }
                    }
                    e3 e3Var3 = this.f31257b;
                    View view2 = this.f31264i;
                    u2 u2Var3 = e3Var3.a;
                    if (u2Var3 != null) {
                        u2Var3.b(view2, null, arrayList);
                    }
                    Handler handler = this.f31266k;
                    if (handler != null) {
                        handler.postDelayed(new m4(this), 3000L);
                    }
                }
                return this.f31264i;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void j() {
        Handler handler;
        a5 a5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!r0.H(this.a)) {
                c1 c1Var = this.f31258c;
                if (c1Var != null) {
                    c1Var.onFail(PBError.NO_NETWORK);
                }
            } else if (this.f31257b == null || (handler = this.f31266k) == null) {
            } else {
                this.f31259d = false;
                this.f31260e = false;
                Message obtain = Message.obtain();
                long u = m2.u(this.a);
                if (u <= 10000) {
                    u = 10000;
                }
                handler.sendMessageDelayed(obtain, u);
                u2 u2Var = this.f31257b.a;
                if (u2Var == null || (a5Var = u2Var.f31471b) == null) {
                    return;
                }
                a5Var.g();
            }
        }
    }

    public void k(c1 c1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, c1Var) == null) {
            this.f31258c = c1Var;
            this.f31257b.f31290b = new p3(this);
        }
    }
}
