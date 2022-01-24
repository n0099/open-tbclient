package c.a.r0.a.y0.k.g;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import c.a.r0.a.y0.d;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.Map;
/* loaded from: classes.dex */
public interface a extends d {

    /* renamed from: c.a.r0.a.y0.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0640a {
        void a(int i2);

        void b(int i2);

        void c(String str);

        void d(@NonNull String str);

        void e(String str);

        void f();

        void onEnded();

        void onError(int i2);

        void onPrepared();

        void onRelease(String str);
    }

    void B(boolean z);

    void C();

    void G(int i2);

    void H();

    void L(int i2, int i3, int i4, int i5);

    void N(ZeusPluginFactory.Invoker invoker);

    boolean O(String str, String str2, String str3, boolean z);

    boolean P();

    InterfaceC0640a Q();

    void T(Map map);

    void U();

    void W();

    int a();

    void b0(String str);

    String c();

    void c0();

    ZeusPluginFactory.Invoker f0();

    void g0(int i2);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    void h0(@NonNull InterfaceC0640a interfaceC0640a);

    boolean isPlaying();

    boolean j0();

    void l(boolean z);

    void n0();

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i2);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void start();
}
