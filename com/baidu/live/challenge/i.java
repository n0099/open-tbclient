package com.baidu.live.challenge;

import com.baidu.live.challenge.ChallenfeInfoData;
import com.baidu.live.data.AlaPersonChallengeData;
import com.baidu.live.data.am;
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.data.r;
import java.util.List;
/* loaded from: classes7.dex */
public interface i {

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, com.baidu.live.challenge.a aVar);

        void g(int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void dF(int i);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void b(ap apVar, at atVar, at atVar2);

        void c(ap apVar, at atVar, at atVar2);

        void d(ap apVar, at atVar, at atVar2);

        void e(ap apVar, at atVar, at atVar2);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void c(boolean z, String str);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(int i, String str, com.baidu.live.challenge.a aVar);

        void b(int i, String str, com.baidu.live.challenge.a aVar);

        void h(int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface f {
        int BU();
    }

    /* loaded from: classes7.dex */
    public interface g {
        void i(int i, String str);

        void v(List<com.baidu.live.challenge.d> list);
    }

    /* loaded from: classes7.dex */
    public interface h {
        void a(com.baidu.live.challenge.d dVar);

        void j(int i, String str);
    }

    /* renamed from: com.baidu.live.challenge.i$i  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0166i {
        void a(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list);

        void k(int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z, String str, com.baidu.live.challenge.a aVar);

        void c(int i, String str, com.baidu.live.challenge.a aVar);

        void l(int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface k {
        void m(int i, String str);

        void w(List<com.baidu.live.challenge.d> list);
    }

    /* loaded from: classes7.dex */
    public interface l {
        void BV();

        void n(int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface m {
        void d(boolean z, String str);
    }

    void BB();

    void BJ();

    void BK();

    void BL();

    void BM();

    void BN();

    void BO();

    ChallenfeInfoData.ChallengeStatus BP();

    boolean BQ();

    void BR();

    long BS();

    void BT();

    void W(long j2);

    void X(long j2);

    void Y(long j2);

    void Z(long j2);

    void a(long j2, long j3, long j4, int i, String str);

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void a(InterfaceC0166i interfaceC0166i);

    void a(j jVar);

    void a(k kVar);

    void a(l lVar);

    void a(m mVar);

    void a(AlaPersonChallengeData alaPersonChallengeData);

    void a(am amVar);

    void bf(boolean z);

    void c(r rVar);

    void dE(int i);

    void e(int i, int i2, String str);

    void e(long j2, long j3);

    void fJ(String str);

    void fK(String str);

    void onDestroy();

    void setIsHost(boolean z);

    void w(int i, int i2);
}
