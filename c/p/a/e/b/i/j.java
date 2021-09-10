package c.p.a.e.b.i;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.k.e;
import c.p.a.e.b.o.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class j implements f, e.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean A;
    public final e.b B;
    public final e.b C;

    /* renamed from: a  reason: collision with root package name */
    public final DownloadInfo f35194a;

    /* renamed from: b  reason: collision with root package name */
    public final m f35195b;

    /* renamed from: c  reason: collision with root package name */
    public final c.p.a.e.b.i.b f35196c;

    /* renamed from: d  reason: collision with root package name */
    public final c.p.a.e.b.k.f f35197d;

    /* renamed from: e  reason: collision with root package name */
    public final g f35198e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f35199f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f35200g;

    /* renamed from: h  reason: collision with root package name */
    public final List<l> f35201h;

    /* renamed from: i  reason: collision with root package name */
    public final List<o> f35202i;

    /* renamed from: j  reason: collision with root package name */
    public c.p.a.e.b.n.b f35203j;
    public c.p.a.e.b.n.b k;
    public volatile boolean l;
    public long m;
    public final LinkedList<i> n;
    public final List<i> o;
    public int p;
    public BaseException q;
    public final Object r;
    public final c.p.a.e.b.l.e s;
    public final c.p.a.e.b.k.e t;
    public volatile boolean u;
    public long v;
    public long w;
    public long x;
    public float y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f35204a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f35205b;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35205b = jVar;
        }

        @Override // c.p.a.e.b.k.e.b
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f35205b.f35199f || this.f35205b.f35200g) {
                    return -1L;
                }
                synchronized (this.f35205b) {
                    if (this.f35205b.f35203j == null && this.f35205b.k == null) {
                        long j2 = this.f35205b.v;
                        if (j2 <= 0) {
                            return -1L;
                        }
                        this.f35204a++;
                        l q = this.f35205b.q(false, System.currentTimeMillis(), j2);
                        if (q != null) {
                            this.f35205b.N(q);
                            q.u();
                            return ((this.f35204a / this.f35205b.f35202i.size()) + 1) * j2;
                        }
                        return j2;
                    }
                    return -1L;
                }
            }
            return invokeV.longValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f35206a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35206a = jVar;
        }

        @Override // c.p.a.e.b.k.e.b
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35206a.k0() : invokeV.longValue;
        }
    }

    public j(@NonNull DownloadInfo downloadInfo, @NonNull m mVar, c.p.a.e.b.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo, mVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35199f = false;
        this.f35200g = false;
        this.f35201h = new ArrayList();
        this.f35202i = new ArrayList();
        this.l = true;
        this.n = new LinkedList<>();
        this.o = new ArrayList();
        this.r = new Object();
        this.u = false;
        this.B = new a(this);
        this.C = new b(this);
        this.f35194a = downloadInfo;
        this.f35195b = mVar;
        c.p.a.e.b.i.b bVar = new c.p.a.e.b.i.b(mVar.g(), this.f35195b.h());
        this.f35196c = bVar;
        this.f35197d = fVar;
        this.f35198e = new g(downloadInfo, fVar, bVar);
        this.t = new c.p.a.e.b.k.e();
        this.s = new c.p.a.e.b.l.e();
        this.A = c.p.a.e.b.j.a.d(downloadInfo.getId()).m("debug") == 1;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, INVOKE, INVOKE, IGET, INVOKE, IF, IGET, IGET, INVOKE, IF] complete} */
    public boolean A(List<i> list) throws BaseException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            try {
                X();
                G(list);
                U();
                Z();
                b0();
                long currentTimeMillis = System.currentTimeMillis();
                L();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.f35194a.increaseAllConnectTime(currentTimeMillis2);
                this.f35194a.setFirstSpeedTime(currentTimeMillis2);
                if (!this.f35200g && !this.f35199f) {
                    this.f35197d.a(this.m);
                    a0();
                    R();
                    return true;
                }
                if (!this.f35200g && !this.f35199f) {
                    c.p.a.e.b.c.a.i("SegmentDispatcher", "finally pause");
                    C();
                }
                this.t.c();
                return true;
            } finally {
                if (!this.f35200g && !this.f35199f) {
                    c.p.a.e.b.c.a.i("SegmentDispatcher", "finally pause");
                    C();
                }
                this.t.c();
            }
        }
        return invokeL.booleanValue;
    }

    public final i B(l lVar, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, oVar)) == null) {
            while (!this.n.isEmpty()) {
                i poll = this.n.poll();
                if (poll != null) {
                    v(this.o, poll, true);
                    if (n(poll) > 0 || this.m <= 0) {
                        return poll;
                    }
                }
            }
            f0();
            i I = I(lVar, oVar);
            if (I != null && n(I) > 0) {
                v(this.o, I, true);
                return I;
            }
            i i0 = i0();
            if (i0 != null) {
                return i0;
            }
            return null;
        }
        return (i) invokeLL.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.p.a.e.b.c.a.i("SegmentDispatcher", "pause1");
            this.f35200g = true;
            synchronized (this) {
                for (l lVar : this.f35201h) {
                    lVar.t();
                }
            }
            this.f35198e.i();
            this.f35196c.c();
        }
    }

    public final void D(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.s.c(this.f35194a.getCurBytes(), j2);
            for (l lVar : this.f35201h) {
                lVar.l(j2);
            }
        }
    }

    public final void E(l lVar, i iVar, o oVar, c.p.a.e.b.n.b bVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, lVar, iVar, oVar, bVar) == null) {
            l lVar2 = iVar.f35191f;
            if (lVar2 != null && lVar2 != lVar) {
                throw new com.ss.android.socialbase.downloader.f.j(1, "segment already has an owner");
            }
            if (lVar.w() == iVar.l()) {
                if (!bVar.b()) {
                    if (iVar.l() <= 0) {
                        c.p.a.e.b.c.a.k("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + iVar.l());
                        if (!bVar.a()) {
                            int i2 = bVar.f35377c;
                            throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "2: response code error : " + bVar.f35377c + " segment=" + iVar);
                        }
                    } else {
                        int i3 = bVar.f35377c;
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, i3, "1: response code error : " + bVar.f35377c + " segment=" + iVar);
                    }
                }
                if (oVar.f35221d) {
                    if (this.f35203j == null) {
                        this.f35203j = bVar;
                        synchronized (this.r) {
                            this.r.notify();
                        }
                        c.p.a.e.b.k.f fVar = this.f35197d;
                        if (fVar != null) {
                            fVar.d(oVar.f35218a, bVar.f35376b, iVar.l());
                        }
                        long j2 = bVar.j();
                        if (j2 > 0) {
                            for (i iVar2 : this.o) {
                                if (iVar2.m() <= 0 || iVar2.m() > j2 - 1) {
                                    iVar2.i(j2 - 1);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                u(bVar);
                if (this.k == null) {
                    this.k = bVar;
                    if (this.f35194a.getTotalBytes() <= 0) {
                        long j3 = bVar.j();
                        c.p.a.e.b.c.a.i("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j3 + ",url=" + oVar.f35218a);
                        this.f35194a.setTotalBytes(j3);
                    }
                    synchronized (this.r) {
                        this.r.notify();
                    }
                    return;
                }
                return;
            }
            throw new com.ss.android.socialbase.downloader.f.j(5, "applySegment");
        }
    }

    public final void F(String str, List<o> list) {
        int l;
        Iterator<o> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, list) == null) {
            if (this.A) {
                while (list.iterator().hasNext()) {
                    String str2 = "addIpListLocked: urlRecord = " + it.next();
                }
            }
            int o = this.f35195b.o();
            if ((o == 1 || o == 3) && (l = l(str)) >= 0 && l < this.f35202i.size()) {
                this.f35202i.addAll(l + 1, list);
            } else {
                this.f35202i.addAll(list);
            }
        }
    }

    public final void G(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            long totalBytes = this.f35194a.getTotalBytes();
            this.m = totalBytes;
            if (totalBytes <= 0) {
                this.m = this.f35194a.getExpectFileLength();
                c.p.a.e.b.c.a.i("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.m);
            }
            synchronized (this) {
                this.n.clear();
                if (list != null && !list.isEmpty()) {
                    for (i iVar : list) {
                        v(this.n, new i(iVar), false);
                    }
                    S(this.n);
                    M(this.n);
                    c.p.a.e.b.c.a.i("SegmentDispatcher", "initSegments: totalLength = " + this.m);
                }
                v(this.n, new i(0L, -1L), false);
                c.p.a.e.b.c.a.i("SegmentDispatcher", "initSegments: totalLength = " + this.m);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final i I(l lVar, o oVar) {
        InterceptResult invokeLL;
        String str;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, lVar, oVar)) == null) {
            int size = this.o.size();
            long j2 = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < size; i3++) {
                long m = m(i3, size);
                if (m > j2) {
                    i2 = i3;
                    j2 = m;
                }
            }
            long j3 = this.f35195b.j();
            long l = this.f35195b.l();
            if (i2 < 0 || j2 <= j3) {
                return null;
            }
            i iVar = this.o.get(i2);
            int q = this.o.size() < this.f35201h.size() ? 2 : this.f35195b.q();
            if (q == 1) {
                l lVar2 = iVar.f35191f;
                if (lVar2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = currentTimeMillis - 4000;
                    long a2 = lVar2.a(j4, currentTimeMillis);
                    long a3 = lVar.a(j4, currentTimeMillis);
                    float f4 = (a2 <= 0 || a3 <= 0) ? -1.0f : ((float) a3) / ((float) (a2 + a3));
                    if (f4 == -1.0f) {
                        long k = lVar2.k();
                        f2 = f4;
                        long k2 = lVar.k();
                        if (k > 0 && k2 > 0) {
                            f3 = ((float) k2) / ((float) (k + k2));
                            if (f3 > 0.0f) {
                                float f5 = f3 * 0.9f;
                                long j5 = ((float) j2) * f5;
                                if (j5 < j3) {
                                    j5 = j3;
                                }
                                if (l <= 0 || j5 <= l) {
                                    l = j5;
                                }
                                long j6 = j3 / 2;
                                long j7 = j2 - j6;
                                if (l > j7) {
                                    l = j7;
                                } else if (l < j6) {
                                    l = j6;
                                }
                                i iVar2 = new i(iVar.l() + (j2 - l), iVar.m());
                                c.p.a.e.b.c.a.i("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar2 + ", maxRemainBytes = " + j2 + ", childLength = " + l + ", ratio = " + f5 + ", threadIndex = " + lVar.x);
                                return iVar2;
                            }
                        }
                    } else {
                        f2 = f4;
                    }
                    f3 = f2;
                    if (f3 > 0.0f) {
                    }
                }
                str = "SegmentDispatcher";
            } else if (q == 2) {
                float O = O(lVar, oVar);
                long curBytes = ((float) (this.m - this.f35194a.getCurBytes())) * O;
                if (curBytes < j3) {
                    curBytes = j3;
                }
                if (l <= 0 || curBytes <= l) {
                    l = curBytes;
                }
                long j8 = j3 / 2;
                long j9 = j2 - j8;
                if (l > j9) {
                    l = j9;
                } else if (l < j8) {
                    l = j8;
                }
                i iVar3 = new i(iVar.l() + (j2 - l), iVar.m());
                c.p.a.e.b.c.a.i("SegmentDispatcher", "obtainSegment: parent = " + iVar + ", child = " + iVar3 + ", maxRemainBytes = " + j2 + ", childLength = " + l + ", ratio = " + O + ", threadIndex = " + lVar.x);
                return iVar3;
            } else {
                str = "SegmentDispatcher";
            }
            i iVar4 = new i(iVar.l() + (j2 / 2), iVar.m());
            c.p.a.e.b.c.a.i(str, "obtainSegment: parent = " + iVar + ",child = " + iVar4);
            return iVar4;
        }
        return (i) invokeLL.objValue;
    }

    public final List<o> K(String str, List<InetAddress> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list)) == null) {
            if (list != null && !list.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i2 = 0;
                for (InetAddress inetAddress : list) {
                    if (inetAddress != null) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (this.A) {
                                String str2 = "onDnsResolved: ip = " + hostAddress;
                            }
                            o oVar = new o(str, hostAddress);
                            LinkedList linkedList = (LinkedList) linkedHashMap.get(oVar.f35220c);
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                                linkedHashMap.put(oVar.f35220c, linkedList);
                            }
                            linkedList.add(oVar);
                            i2++;
                        }
                    }
                }
                if (i2 > 0) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        z = false;
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            LinkedList linkedList2 = (LinkedList) entry.getValue();
                            if (linkedList2 != null && !linkedList2.isEmpty()) {
                                arrayList.add((o) linkedList2.pollFirst());
                                i2--;
                                z = true;
                            }
                        }
                        if (i2 <= 0) {
                            break;
                        }
                    } while (z);
                    return arrayList;
                }
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public final void L() throws BaseException, InterruptedException {
        BaseException baseException;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.r) {
                if (this.f35203j == null && this.k == null) {
                    this.r.wait();
                }
            }
            if (this.f35203j == null && this.k == null && (baseException = this.q) != null) {
                throw baseException;
            }
        }
    }

    public final void M(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            long b2 = n.b(list);
            c.p.a.e.b.c.a.i("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f35194a.getCurBytes() + ", totalBytes = " + this.f35194a.getTotalBytes() + ", downloadedBytes = " + b2);
            if (b2 > this.f35194a.getTotalBytes() && this.f35194a.getTotalBytes() > 0) {
                b2 = this.f35194a.getTotalBytes();
            }
            if (this.f35194a.getCurBytes() == this.f35194a.getTotalBytes() || this.f35194a.getCurBytes() == b2) {
                return;
            }
            this.f35194a.setCurBytes(b2);
        }
    }

    public final boolean N(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, lVar)) == null) {
            synchronized (this) {
                o P = P(lVar);
                if (P == null) {
                    return false;
                }
                return lVar.j(P);
            }
        }
        return invokeL.booleanValue;
    }

    public final float O(l lVar, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, lVar, oVar)) == null) {
            long k = lVar.k();
            int size = this.f35201h.size();
            if (size <= 1) {
                size = this.f35195b.a();
            }
            float f2 = 1.0f;
            if (k <= 0) {
                float p = this.f35195b.p();
                if (p <= 0.0f || p >= 1.0f) {
                    p = 1.0f / size;
                }
                if (lVar.x == 0) {
                    return p;
                }
                if (size > 1) {
                    f2 = 1.0f - p;
                    size--;
                }
            } else {
                long h0 = h0();
                if (h0 > k) {
                    return ((float) k) / ((float) h0);
                }
            }
            return f2 / size;
        }
        return invokeLL.floatValue;
    }

    public final o P(l lVar) {
        InterceptResult invokeL;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, lVar)) == null) {
            Iterator<o> it = this.f35202i.iterator();
            o oVar2 = null;
            while (true) {
                if (!it.hasNext()) {
                    oVar = null;
                    break;
                }
                oVar = it.next();
                if (oVar != lVar.m && !oVar.h()) {
                    if (oVar2 == null) {
                        oVar2 = oVar;
                    }
                    if (oVar.a() <= 0) {
                        break;
                    }
                }
            }
            if (this.f35195b.e()) {
                if (oVar != null) {
                    return oVar;
                }
                if (this.f35195b.f()) {
                    return null;
                }
            }
            return oVar2;
        }
        return (o) invokeL.objValue;
    }

    public final void R() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                this.f35198e.c(this.f35196c);
            } catch (p unused) {
            } catch (BaseException e2) {
                c.p.a.e.b.c.a.k("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
                s(e2);
                throw e2;
            }
            if (this.f35200g || this.f35199f) {
                return;
            }
            try {
                synchronized (this) {
                    while (!this.n.isEmpty()) {
                        i poll = this.n.poll();
                        if (poll != null) {
                            v(this.o, poll, true);
                        }
                    }
                    M(this.o);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.u && this.q != null) {
                c.p.a.e.b.c.a.k("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.q);
                throw this.q;
            }
            if (this.f35194a.getCurBytes() != this.f35194a.getTotalBytes()) {
                c.p.a.e.b.e.a.h(this.f35194a, this.o);
            }
            c.p.a.e.b.c.a.i("SegmentDispatcher", "dispatchSegments::download finished");
        }
    }

    public final void S(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            i iVar = list.get(0);
            long h2 = iVar.h();
            if (h2 > 0) {
                i iVar2 = new i(0L, h2 - 1);
                r0 = "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2;
                v(list, iVar2, true);
            }
            Iterator<i> it = list.iterator();
            if (it.hasNext()) {
                i next = it.next();
                while (it.hasNext()) {
                    i next2 = it.next();
                    if (next.m() < next2.h() - 1) {
                        c.p.a.e.b.c.a.j("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.h() - 1));
                        next.i(next2.h() - 1);
                    }
                    next = next2;
                }
            }
            i iVar3 = list.get(list.size() - 1);
            long totalBytes = this.f35194a.getTotalBytes();
            if (totalBytes <= 0 || (iVar3.m() != -1 && iVar3.m() < totalBytes - 1)) {
                c.p.a.e.b.c.a.j("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
                iVar3.i(-1L);
            }
        }
    }

    public final void U() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.m <= 0 || this.l) {
                i2 = 1;
            } else {
                i2 = this.f35195b.a();
                int k = (int) (this.m / this.f35195b.k());
                if (i2 > k) {
                    i2 = k;
                }
            }
            c.p.a.e.b.c.a.i("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + i2);
            int i3 = i2 > 0 ? i2 : 1;
            synchronized (this) {
                do {
                    if (this.f35201h.size() >= i3) {
                        break;
                    }
                    if (!this.f35200g && !this.f35199f) {
                        t(c0());
                    }
                    return;
                } while (!this.f35195b.i());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
        if ((r10.l() - r24.l()) < (r14 / 2)) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(l lVar, i iVar) throws com.ss.android.socialbase.downloader.f.j {
        i iVar2;
        long j2;
        long m;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, lVar, iVar) == null) {
            c.p.a.e.b.c.a.i("SegmentDispatcher", "applySegment: start " + iVar);
            if (iVar.f35191f != lVar) {
                if (iVar.f35191f == null) {
                    if (lVar.w() == iVar.l()) {
                        long h2 = iVar.h();
                        int k = k(h2);
                        if (k != -1 && (iVar2 = this.o.get(k)) != null) {
                            if (iVar2 != iVar) {
                                if (iVar2.h() == iVar.h()) {
                                    long n = n(iVar2);
                                    if (n > 0) {
                                        l lVar2 = iVar2.f35191f;
                                        if (lVar2 != null) {
                                            if (n < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                                j2 = h2;
                                                if (lVar.K - lVar2.K > 1000) {
                                                }
                                            } else {
                                                j2 = h2;
                                            }
                                            String str = "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = " + iVar2;
                                            z = false;
                                            if (!z) {
                                                c.p.a.e.b.c.a.k("SegmentDispatcher", "applySegment: " + iVar + " not exist! but has another same segment, segmentInList = " + iVar2);
                                                throw new com.ss.android.socialbase.downloader.f.j(2, "segment not exist, but has another same segment");
                                            }
                                        } else {
                                            j2 = h2;
                                        }
                                        if (lVar2 != null) {
                                            String str2 = "applySegmentLocked: has same segment,and owner too slow, segmentInList = " + iVar2;
                                            lVar2.e(true);
                                        } else {
                                            String str3 = "applySegmentLocked: has same segment and no owner, segmentInList = " + iVar2;
                                        }
                                        iVar.i(iVar2.m());
                                        iVar.f(iVar2.q());
                                        this.o.set(k, iVar);
                                        z = true;
                                        if (!z) {
                                        }
                                    }
                                }
                                j2 = h2;
                                z = false;
                                if (!z) {
                                }
                            } else {
                                j2 = h2;
                            }
                            long a2 = iVar.a();
                            int i2 = k - 1;
                            while (true) {
                                if (i2 < 0) {
                                    break;
                                }
                                i iVar3 = this.o.get(i2);
                                long m2 = iVar3.m();
                                if (m2 <= 0 || m2 >= j2) {
                                    if (a2 <= 0 && iVar3.l() > j2) {
                                        c.p.a.e.b.c.a.k("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + iVar3 + ", segment = " + iVar);
                                        this.o.remove(iVar);
                                        throw new com.ss.android.socialbase.downloader.f.j(3, "prev overstep");
                                    } else if (iVar3.f35191f == null) {
                                        iVar3.i(j2 - 1);
                                        c.p.a.e.b.c.a.i("SegmentDispatcher", "applySegment: prev set end, prev = " + iVar3);
                                        if (iVar3.a() > 0) {
                                            break;
                                        }
                                    } else {
                                        long j3 = j2 - 1;
                                        if (iVar3.f35191f.f(j3)) {
                                            iVar3.i(j3);
                                            c.p.a.e.b.c.a.i("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = " + iVar3);
                                        } else {
                                            c.p.a.e.b.c.a.k("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = " + iVar3);
                                            throw new com.ss.android.socialbase.downloader.f.j(4, "prev end adjust fail");
                                        }
                                    }
                                }
                                i2--;
                            }
                            int size = this.o.size();
                            for (int i3 = k + 1; i3 < size; i3++) {
                                i iVar4 = this.o.get(i3);
                                if (iVar4.a() > 0 || iVar4.f35191f != null) {
                                    long m3 = iVar.m();
                                    long h3 = iVar4.h();
                                    if (m3 <= 0 || m3 >= h3) {
                                        long j4 = h3 - 1;
                                        iVar.i(j4);
                                        c.p.a.e.b.c.a.i("SegmentDispatcher", "applySegment: segment set end:" + j4 + ", later = " + iVar4);
                                    }
                                    m = iVar.m();
                                    if (m <= 0 && (j2 > m || iVar.l() > m)) {
                                        throw new com.ss.android.socialbase.downloader.f.j(6, "applySegment: " + iVar);
                                    }
                                    iVar.f35191f = lVar;
                                    c.p.a.e.b.c.a.i("SegmentDispatcher", "applySegment: OK " + iVar);
                                    return;
                                }
                            }
                            m = iVar.m();
                            if (m <= 0) {
                            }
                            iVar.f35191f = lVar;
                            c.p.a.e.b.c.a.i("SegmentDispatcher", "applySegment: OK " + iVar);
                            return;
                        }
                        c.p.a.e.b.c.a.k("SegmentDispatcher", "applySegment: " + iVar + " not exist! segmentIndex = " + k);
                        throw new com.ss.android.socialbase.downloader.f.j(2, "segment not exist");
                    }
                    throw new com.ss.android.socialbase.downloader.f.j(5, "applySegment");
                } else {
                    c.p.a.e.b.c.a.k("SegmentDispatcher", "applySegment: " + iVar + " is already has an owner:" + iVar.f35191f);
                    throw new com.ss.android.socialbase.downloader.f.j(1, "segment already has an owner");
                }
            }
            c.p.a.e.b.c.a.i("SegmentDispatcher", "applySegment: " + lVar + " is already the owner of " + iVar);
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f35202i.add(new o(this.f35194a.getUrl(), true));
            List<String> backUpUrls = this.f35194a.getBackUpUrls();
            if (backUpUrls != null) {
                for (String str : backUpUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f35202i.add(new o(str, false));
                    }
                }
            }
            this.f35195b.c(this.f35202i.size());
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            m mVar = this.f35195b;
            this.v = mVar.m();
            this.w = mVar.n();
            this.y = mVar.r();
            int i2 = this.z;
            if (i2 > 0) {
                this.t.b(this.B, i2);
            }
        }
    }

    @Override // c.p.a.e.b.o.e.c
    public void a(String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, list) == null) || this.f35200g || this.f35199f) {
            return;
        }
        List<o> list2 = null;
        try {
            list2 = K(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                F(str, list2);
            }
            this.l = false;
            this.f35195b.c(this.f35202i.size());
            U();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.w <= 0) {
            return;
        }
        this.x = System.currentTimeMillis();
        this.t.b(this.C, 0L);
    }

    @Override // c.p.a.e.b.i.f
    public void b(l lVar, i iVar, o oVar, c.p.a.e.b.n.b bVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048599, this, lVar, iVar, oVar, bVar) == null) {
            synchronized (this) {
                if (!this.f35199f && !this.f35200g) {
                    E(lVar, iVar, oVar, bVar);
                    lVar.n(false);
                    if (this.m <= 0) {
                        long totalBytes = this.f35194a.getTotalBytes();
                        this.m = totalBytes;
                        if (totalBytes <= 0) {
                            this.m = bVar.j();
                        }
                        U();
                    } else if (this.f35195b.i()) {
                        U();
                    }
                } else {
                    throw new p("connected");
                }
            }
        }
    }

    public final void b0() {
        List<String> backUpUrls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            int o = this.f35195b.o();
            if (o <= 0) {
                this.l = false;
                U();
                return;
            }
            c.p.a.e.b.o.e a2 = c.p.a.e.b.o.e.a();
            a2.c(this.f35194a.getUrl(), this, 2000L);
            if (o <= 2 || (backUpUrls = this.f35194a.getBackUpUrls()) == null) {
                return;
            }
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    a2.c(str, this, 2000L);
                }
            }
        }
    }

    @Override // c.p.a.e.b.i.f
    public i c(l lVar, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, lVar, oVar)) == null) {
            if (this.f35199f || this.f35200g) {
                return null;
            }
            synchronized (this) {
                i B = B(lVar, oVar);
                if (B != null) {
                    B.o();
                    if (B.q() > 1) {
                        return new i(B);
                    }
                }
                return B;
            }
        }
        return (i) invokeLL.objValue;
    }

    public final o c0() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            synchronized (this) {
                int size = this.p % this.f35202i.size();
                if (this.f35195b.e()) {
                    this.p++;
                }
                oVar = this.f35202i.get(size);
            }
            return oVar;
        }
        return (o) invokeV.objValue;
    }

    @Override // c.p.a.e.b.i.f
    public void d(l lVar, i iVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, lVar, iVar) == null) {
            synchronized (this) {
                V(lVar, iVar);
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c.p.a.e.b.c.a.i("SegmentDispatcher", "onComplete");
            this.f35196c.c();
            synchronized (this.r) {
                this.r.notify();
            }
        }
    }

    @Override // c.p.a.e.b.i.f
    public void e(l lVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, lVar, iVar) == null) {
            synchronized (this) {
                iVar.p();
            }
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            for (l lVar : this.f35201h) {
                if (!lVar.v()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.i.f
    public void f(l lVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, lVar, iVar) == null) {
            synchronized (this) {
                if (iVar.f35191f == lVar) {
                    c.p.a.e.b.c.a.i("SegmentDispatcher", "unApplySegment " + iVar);
                    iVar.k(lVar.r());
                    iVar.f35191f = null;
                    lVar.c();
                }
            }
        }
    }

    public final void f0() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.m <= 0 || (size = this.o.size()) <= 1) {
            return;
        }
        ArrayList<i> arrayList = null;
        int i2 = 0;
        for (int i3 = 1; i3 < size; i3++) {
            i iVar = this.o.get(i2);
            i iVar2 = this.o.get(i3);
            if (iVar.l() > iVar2.h() && iVar2.a() <= 0 && iVar2.f35191f == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                }
                arrayList.add(iVar2);
                if (this.A) {
                    String str = "clearCovered, covered = " + iVar2 + ", prev = " + iVar;
                }
            } else if (iVar2.l() > iVar.l()) {
                i2++;
            }
        }
        if (arrayList != null) {
            for (i iVar3 : arrayList) {
                this.o.remove(iVar3);
                for (l lVar : this.f35201h) {
                    if (lVar.l == iVar3) {
                        if (this.A) {
                            String str2 = "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + lVar.x;
                        }
                        lVar.e(true);
                    }
                }
            }
        }
    }

    @Override // c.p.a.e.b.i.f
    public void g(l lVar, o oVar, i iVar, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048609, this, lVar, oVar, iVar, baseException) == null) {
            synchronized (this) {
                c.p.a.e.b.c.a.k("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
                lVar.n(true);
                if (lVar.x == 0) {
                    this.q = baseException;
                }
                if (e0()) {
                    if (this.q == null) {
                        this.q = baseException;
                    }
                    this.u = true;
                    s(this.q);
                }
            }
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            long j2 = this.m;
            if (j2 <= 0) {
                return false;
            }
            synchronized (this) {
                long a2 = n.a(this.o);
                c.p.a.e.b.c.a.i("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a2);
                return a2 >= j2;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // c.p.a.e.b.i.f
    public e h(l lVar, i iVar) throws BaseException {
        InterceptResult invokeLL;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, lVar, iVar)) == null) {
            synchronized (this) {
                k kVar = new k(this.f35194a, this.f35196c, iVar);
                this.f35198e.e(kVar);
                a2 = kVar.a();
            }
            return a2;
        }
        return (e) invokeLL.objValue;
    }

    public final long h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            long j2 = 0;
            for (l lVar : this.f35201h) {
                j2 += lVar.k();
            }
            return j2;
        }
        return invokeV.longValue;
    }

    @Override // c.p.a.e.b.i.f
    public void i(l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, lVar) == null) && this.A) {
            c.p.a.e.b.c.a.i("SegmentDispatcher", "onReaderRun, threadIndex = " + lVar.x);
        }
    }

    public final i i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048614, this)) != null) {
            return (i) invokeV.objValue;
        }
        int i2 = 0;
        while (true) {
            i j0 = j0();
            if (j0 == null) {
                return null;
            }
            l lVar = j0.f35191f;
            if (lVar == null) {
                return j0;
            }
            if (j0.q() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            D(currentTimeMillis);
            if (currentTimeMillis - lVar.K > 2000 && z(lVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.A) {
                    String str = "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + j0 + ", owner.threadIndex = " + lVar.x;
                }
                return j0;
            }
            int i3 = i2 + 1;
            if (i2 > 2) {
                if (this.A) {
                    String str2 = "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + j0;
                }
                return j0;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i2 = i3;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    @Override // c.p.a.e.b.i.f
    public void j(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, lVar) == null) {
            c.p.a.e.b.c.a.i("SegmentDispatcher", "onReaderExit: threadIndex = " + lVar.x);
            synchronized (this) {
                lVar.q(true);
                this.f35201h.remove(lVar);
                f0();
                if (this.f35201h.isEmpty()) {
                    d0();
                } else if (g0()) {
                    for (l lVar2 : this.f35201h) {
                        lVar2.t();
                    }
                    d0();
                }
            }
        }
    }

    public final i j0() {
        InterceptResult invokeV;
        int q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            i iVar = null;
            int i2 = Integer.MAX_VALUE;
            for (i iVar2 : this.o) {
                if (n(iVar2) > 0 && (q = iVar2.q()) < i2) {
                    iVar = iVar2;
                    i2 = q;
                }
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }

    public final int k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048617, this, j2)) == null) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = this.o.get(i2);
                if (iVar.h() == j2) {
                    return i2;
                }
                if (iVar.h() > j2) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public final long k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.f35199f || this.f35200g) {
                return -1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                D(currentTimeMillis);
                long n = this.f35195b.n();
                if (n > 0) {
                    long j2 = this.x;
                    if (j2 > 0 && currentTimeMillis - j2 > n && w(currentTimeMillis, n)) {
                        this.x = currentTimeMillis;
                        this.z++;
                    }
                }
            }
            return 2000L;
        }
        return invokeV.longValue;
    }

    public final int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            int size = this.f35202i.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (TextUtils.equals(this.f35202i.get(i2).f35218a, str)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final long m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048620, this, i2, i3)) == null) {
            i iVar = this.o.get(i2);
            long n = n(iVar);
            int i4 = i2 + 1;
            i iVar2 = i4 < i3 ? this.o.get(i4) : null;
            if (iVar2 == null) {
                return n;
            }
            long h2 = iVar2.h() - iVar.l();
            return n == -1 ? h2 : Math.min(n, h2);
        }
        return invokeII.longValue;
    }

    public final long n(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, iVar)) == null) {
            long e2 = iVar.e();
            if (e2 == -1) {
                long j2 = this.m;
                return j2 > 0 ? j2 - iVar.l() : e2;
            }
            return e2;
        }
        return invokeL.longValue;
    }

    public final l o(long j2, long j3, long j4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2)})) == null) {
            long j5 = Long.MAX_VALUE;
            int i3 = 0;
            l lVar = null;
            for (l lVar2 : this.f35201h) {
                if (lVar2.K > 0) {
                    i3++;
                    long j6 = j5;
                    if (lVar2.K < j2) {
                        long a2 = lVar2.a(j2, j3);
                        if (this.A) {
                            String str = "findPoorReadThread: speed = " + a2 + ", threadIndex = " + lVar2.x;
                        }
                        if (a2 >= 0 && a2 < j6) {
                            j5 = a2;
                            lVar = lVar2;
                        }
                    }
                    j5 = j6;
                }
            }
            long j7 = j5;
            if (lVar == null || i3 < i2 || j7 >= j4) {
                return null;
            }
            c.p.a.e.b.c.a.i("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + lVar.x);
            return lVar;
        }
        return (l) invokeCommon.objValue;
    }

    public final l q(boolean z, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            l lVar = null;
            for (l lVar2 : this.f35201h) {
                if (lVar2.x != 0 || z) {
                    if (lVar2.I > 0 && lVar2.J <= 0 && j2 - lVar2.I > j3 && (lVar == null || lVar2.I < lVar.I)) {
                        lVar = lVar2;
                    }
                }
            }
            return lVar;
        }
        return (l) invokeCommon.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            c.p.a.e.b.c.a.i("SegmentDispatcher", QueryResponse.Options.CANCEL);
            this.f35199f = true;
            synchronized (this) {
                for (l lVar : this.f35201h) {
                    lVar.t();
                }
            }
            this.f35198e.a();
            this.f35196c.c();
        }
    }

    public final void s(BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, baseException) == null) {
            c.p.a.e.b.c.a.k("SegmentDispatcher", "onError, e = " + baseException);
            this.q = baseException;
            this.f35196c.c();
            synchronized (this) {
                for (l lVar : this.f35201h) {
                    lVar.t();
                }
            }
        }
    }

    public final void t(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, oVar) == null) {
            l lVar = new l(this.f35194a, this, this.f35196c, oVar, this.f35201h.size());
            this.f35201h.add(lVar);
            lVar.d(c.p.a.e.b.g.e.F0().submit(lVar));
        }
    }

    public final void u(c.p.a.e.b.n.b bVar) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bVar) == null) {
            c.p.a.e.b.n.b bVar2 = this.f35203j;
            if (bVar2 == null && (bVar2 = this.k) == null) {
                return;
            }
            long j2 = bVar.j();
            long j3 = bVar2.j();
            if (j2 != j3) {
                String str = "total len not equals,len=" + j2 + ",sLen=" + j3 + ",code=" + bVar.f35377c + ",sCode=" + bVar2.f35377c + ",range=" + bVar.e() + ",sRange = " + bVar2.e() + ",url = " + bVar.f35375a + ",sUrl=" + bVar2.f35375a;
                c.p.a.e.b.c.a.k("SegmentDispatcher", str);
                if (j2 > 0 && j3 > 0) {
                    throw new BaseException(1074, str);
                }
            }
            String c2 = bVar.c();
            String c3 = bVar2.c();
            if (TextUtils.equals(c2, c3)) {
                return;
            }
            String str2 = "etag not equals with main url, etag = " + c2 + ", mainEtag = " + c3;
            c.p.a.e.b.c.a.k("SegmentDispatcher", str2);
            if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(c3) && !c2.equalsIgnoreCase(c3)) {
                throw new BaseException(1074, str2);
            }
        }
    }

    public final void v(List<i> list, i iVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048628, this, list, iVar, z) == null) {
            long h2 = iVar.h();
            int size = list.size();
            int i2 = 0;
            while (i2 < size && h2 >= list.get(i2).h()) {
                i2++;
            }
            list.add(i2, iVar);
            if (z) {
                iVar.c(size);
            }
        }
    }

    public final boolean w(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j2 - j3;
            long d2 = this.s.d(j4, j2);
            int size = this.f35201h.size();
            if (size > 0) {
                d2 /= size;
            }
            l o = o(j4, j2, Math.max(10.0f, ((float) d2) * this.y), size / 2);
            if (o != null) {
                N(o);
                c.p.a.e.b.c.a.j("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + o.x);
                o.u();
                return true;
            }
            l q = q(true, j2, j3);
            if (q != null) {
                N(q);
                c.p.a.e.b.c.a.j("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + q.x);
                q.u();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean z(l lVar, long j2, long j3, long j4, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{lVar, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Double.valueOf(d2)})) == null) {
            if (lVar.K > 0) {
                long d3 = this.s.d(j2, j3);
                int size = this.f35201h.size();
                long j5 = size > 0 ? d3 / size : d3;
                long a2 = lVar.a(j2, j3);
                if (a2 < j4 || a2 < j5 * d2) {
                    String str = "isDownloadSpeedPoor: totalSpeed = " + d3 + ", threadAvgSpeed = " + j5 + ", poorSpeed = " + j4 + ", speed = " + a2 + ",threadIndex = " + lVar.x;
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.p.a.e.b.i.f
    public void a(l lVar, o oVar, i iVar, BaseException baseException, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{lVar, oVar, iVar, baseException, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            c.p.a.e.b.l.f.h0(baseException);
            int errorCode = baseException.getErrorCode();
            if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i2 >= i3) {
                N(lVar);
            }
        }
    }
}
