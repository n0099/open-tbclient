package c.a.a0.v.h0;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes.dex */
public class f implements c.a.a0.v.f0.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f1727b;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f1727b = 0;
    }

    @Override // c.a.a0.v.f0.d
    public void a(c.a.a0.v.m0.a aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.f1795g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        if (!TextUtils.isEmpty(aVar.f1794f)) {
            clogBuilder.r(aVar.f1794f);
        }
        clogBuilder.n(aVar.f1795g);
        String c2 = aVar.a.c();
        char c3 = 65535;
        switch (c2.hashCode()) {
            case -1530009462:
                if (c2.equals(ControlEvent.ACTION_SYNC_PROGRESS)) {
                    c3 = 5;
                    break;
                }
                break;
            case 154871702:
                if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                    c3 = 4;
                    break;
                }
                break;
            case 720027695:
                if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                    c3 = 1;
                    break;
                }
                break;
            case 723345051:
                if (c2.equals(ControlEvent.ACTION_START)) {
                    c3 = 0;
                    break;
                }
                break;
            case 906917140:
                if (c2.equals(ControlEvent.ACTION_RESUME)) {
                    c3 = 2;
                    break;
                }
                break;
            case 2145795460:
                if (c2.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c3 = 3;
                    break;
                }
                break;
        }
        if (c3 == 0) {
            clogBuilder.s(ClogBuilder.LogType.VIDEO_START).i(aVar.f1790b).k(aVar.f1792d);
            this.f1727b = 0;
            this.a++;
            c.a.a0.a0.a.b(clogBuilder);
        } else if (c3 == 1) {
            boolean d2 = aVar.a.d(7);
            clogBuilder.j(aVar.f1791c).k(aVar.f1792d).l(aVar.f1793e);
            if (d2) {
                clogBuilder.s(ClogBuilder.LogType.VIDEO_PAUSE);
            } else {
                clogBuilder.s(ClogBuilder.LogType.VIDEO_COMPLETED).m("1");
            }
            c.a.a0.a0.a.b(clogBuilder);
        } else if (c3 == 2) {
            clogBuilder.s(ClogBuilder.LogType.VIDEO_RESUME).i(aVar.f1790b).k(aVar.f1792d);
            c.a.a0.a0.a.b(clogBuilder);
        } else if (c3 == 3 || c3 == 4) {
            if (this.a < 1) {
                return;
            }
            try {
                if (this.f1727b > Integer.parseInt(aVar.f1791c)) {
                    clogBuilder.j(aVar.f1792d);
                } else {
                    clogBuilder.j(aVar.f1791c);
                }
            } catch (NumberFormatException unused) {
                clogBuilder.j(aVar.f1791c);
            }
            clogBuilder.s(ClogBuilder.LogType.VIDEO_COMPLETED).k(aVar.f1792d).l(aVar.f1793e).m("0");
            this.a--;
            c.a.a0.a0.a.b(clogBuilder);
        } else if (c3 != 5) {
        } else {
            int g2 = aVar.a.g(1);
            int g3 = aVar.a.g(2);
            if (g2 == 0 && g3 != 0 && (i = this.f1727b) != 0 && i >= g3 - 2) {
                clogBuilder.s(ClogBuilder.LogType.VIDEO_COMPLETED).j(String.valueOf(g3)).k(String.valueOf(g3)).l(aVar.f1793e);
                c.a.a0.a0.a.b(clogBuilder);
                ClogBuilder n = new ClogBuilder().s(ClogBuilder.LogType.VIDEO_START).i(aVar.f1790b).k(aVar.f1792d).n(aVar.f1795g);
                if (!TextUtils.isEmpty(aVar.f1794f)) {
                    n.r(aVar.f1794f);
                }
                c.a.a0.a0.a.b(n);
            }
            this.f1727b = g2;
        }
    }

    @Override // c.a.a0.v.f0.d
    public void b(c.a.a0.v.m0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null || aVar.a == null || TextUtils.isEmpty(aVar.f1795g)) {
            return;
        }
        String c2 = aVar.a.c();
        char c3 = 65535;
        int hashCode = c2.hashCode();
        if (hashCode != 154871702) {
            if (hashCode != 1370689931) {
                if (hashCode == 2145795460 && c2.equals(StatisticsEvent.ACTION_PLAYER_STOP)) {
                    c3 = 1;
                }
            } else if (c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                c3 = 0;
            }
        } else if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
            c3 = 2;
        }
        if (c3 != 0) {
            if (c3 == 1 || c3 == 2) {
                c.a.a0.v.m0.b.f1797b.b();
                return;
            }
            return;
        }
        c.a.a0.v.m0.g a = c.a.a0.v.m0.b.f1797b.a();
        if (a != null) {
            a.c(aVar.f1795g);
            a.e(aVar.f1790b);
            a.d(aVar.f1796h);
            a.b(aVar.f1792d);
            c.a.a0.v.m0.b.f1797b.c(a);
        }
    }
}
