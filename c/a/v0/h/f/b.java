package c.a.v0.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.l.d.f;
import c.a.v0.q.a;
import c.a.v0.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends c.a.v0.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f21571h;
    public int i;
    public int j;
    public c.a.v0.h.a k;
    public long l;
    public boolean m;
    public boolean n;
    public c.a.v0.h.b o;
    public boolean p;
    public boolean q;
    public c.a.v0.h.c r;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21572b;

        public a(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21572b = bVar;
            this.a = sb;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f21572b) {
                    this.f21572b.notifyAll();
                }
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",createMuteAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.v0.r.c.j("FFmpegChain", sb2);
                synchronized (this.f21572b) {
                    this.f21572b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                c.a.v0.r.c.j("FFmpegChain", " createMuteAudio 进度i1 = " + i2);
                b bVar = this.f21572b;
                bVar.i((int) (((float) bVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* renamed from: c.a.v0.h.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1600b implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21573b;

        public C1600b(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21573b = bVar;
            this.a = sb;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f21573b) {
                    this.f21573b.notifyAll();
                }
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.v0.r.c.j("FFmpegChain", sb2);
                synchronized (this.f21573b) {
                    this.f21573b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                c.a.v0.r.c.j("FFmpegChain", " concatMuteAudio 进度i1 = " + i2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.h.a f21574b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f21575c;

        public c(b bVar, StringBuilder sb, c.a.v0.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21575c = bVar;
            this.a = sb;
            this.f21574b = aVar;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f21575c) {
                    this.f21575c.notifyAll();
                }
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",dealAudioPlayData ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.v0.h.a aVar = this.f21574b;
                if (aVar != null && aVar.a() != null) {
                    this.a.append(",audioformat:");
                    this.a.append(this.f21574b.a().f());
                    this.a.append(",audiopath:");
                    this.a.append(this.f21574b.a().h());
                }
                c.a.v0.r.c.j("FFmpegChain", sb2);
                synchronized (this.f21575c) {
                    this.f21575c.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                c.a.v0.r.c.j("FFmpegChain", " dealAudioPlayData 进度i1 = " + i2);
                b bVar = this.f21575c;
                bVar.i(bVar.i + ((int) ((((((float) (this.f21575c.j + (-1))) + ((((float) i2) * 1.0f) / 100.0f)) * 1.0f) / ((float) this.f21575c.f21571h)) * 60.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21576b;

        public d(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21576b = bVar;
            this.a = sb;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f21576b) {
                    this.f21576b.notifyAll();
                }
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.v0.r.c.j("FFmpegChain", sb2);
                synchronized (this.f21576b) {
                    this.f21576b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                c.a.v0.r.c.j("FFmpegChain", " concatAudio 进度i1 = " + i2);
                b bVar = this.f21576b;
                bVar.i((int) (((float) bVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.InterfaceC1617a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f21577b;

        public e(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21577b = bVar;
            this.a = sb;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f21577b) {
                    this.f21577b.notifyAll();
                }
            }
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("mixAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.v0.r.c.j("FFmpegChain", sb2);
                synchronized (this.f21577b) {
                    this.f21577b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.v0.q.a.InterfaceC1617a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                c.a.v0.r.c.j("FFmpegChain", " mixAudio 进度i1 = " + i2);
                b bVar = this.f21577b;
                bVar.i((int) (((float) bVar.i) + (((((float) i2) * 1.0f) / 100.0f) * 20.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    public b() {
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

    public final void A() {
        String str;
        String a2;
        c.a.v0.h.b bVar;
        c.a.v0.h.a aVar;
        c.a.v0.h.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.v0.h.a aVar2 = this.k;
            boolean z = aVar2 != null && aVar2.c();
            if (!z && ((bVar2 = this.o) == null || !FileUtils.isExists(bVar2.h()))) {
                g("nosource to create mute audio");
                return;
            }
            if (z && (bVar = this.o) != null && (aVar = this.k) != null && !bVar.equals(aVar.a())) {
                z = false;
            }
            StringBuilder sb = new StringBuilder();
            str = "";
            if (!z) {
                try {
                } catch (Throwable th) {
                    sb.append(th.getMessage());
                }
                if (this.o == null) {
                    return;
                }
                str = a(this.o.h(), "_mute.aac");
                f.l(this.o.h(), str, -1, -1, 0.0f, -1, 0.0f, -1.0f, false, new a(this, sb));
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e2) {
                    sb.append(e2.getMessage());
                }
                if (FileUtils.isExists(a2) && TextUtils.isEmpty(sb.toString())) {
                    c.a.v0.r.c.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                    this.k = new c.a.v0.h.a(new AudioPlayData(a2, 0, -1, 1.0f));
                    return;
                }
                g(sb.toString());
            }
            c.a.v0.h.a aVar3 = this.k;
            str = aVar3 != null ? aVar3.a().h() : "";
            i(this.i + 10);
            if (FileUtils.isExists(str) && TextUtils.isEmpty(sb.toString())) {
                c.a.v0.r.c.j("FFmpegChain", "createMuteAudio 生成成功");
                c.a.v0.h.a aVar4 = new c.a.v0.h.a(new AudioPlayData(str, 0, -1, 1.0f));
                this.k = aVar4;
                if (aVar4.a() == null || this.k.a().e() <= 0) {
                    return;
                }
                long e3 = this.k.a().e();
                long j = this.l;
                if (e3 >= j) {
                    return;
                }
                int e4 = (int) ((j / this.k.a().e()) + 1);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < e4; i++) {
                    arrayList.add(str);
                }
                a2 = a(str, "_concat.aac");
                f.b(arrayList, a2, this.f21570g, new C1600b(this, sb), false, true);
                try {
                } catch (InterruptedException e5) {
                    sb.append(e5.getMessage());
                }
                synchronized (this) {
                    wait();
                    if (FileUtils.isExists(a2)) {
                        c.a.v0.r.c.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                        this.k = new c.a.v0.h.a(new AudioPlayData(a2, 0, -1, 1.0f));
                        return;
                    }
                }
            }
            g(sb.toString());
        }
    }

    public final void B(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("concatAudio tempDataForOutPut data error");
                return;
            }
            List<c.a.v0.h.e> c2 = cVar.c();
            StringBuilder sb = new StringBuilder();
            for (c.a.v0.h.e eVar : c2) {
                if (!h.e(eVar.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (c.a.v0.h.a aVar : eVar.a()) {
                        if (aVar.b() != null) {
                            arrayList.add(aVar.b().audioPath);
                        }
                    }
                    if (!h.e(arrayList)) {
                        String str = this.f21570g;
                        if (TextUtils.isEmpty(str)) {
                            str = FileUtils.getParentDir((String) arrayList.get(0));
                        }
                        String str2 = str + System.currentTimeMillis() + "_trackconcat.aac";
                        f.b(arrayList, str2, this.f21570g, new d(this, sb), false, true);
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e2) {
                            sb.append(e2.getMessage());
                        }
                        if (FileUtils.isExists(str2) && TextUtils.isEmpty(sb.toString())) {
                            c.a.v0.r.c.j("FFmpegChain", "concatAudio 生成成功");
                            c.a.v0.h.a aVar2 = new c.a.v0.h.a(new AudioPlayData(str2, 0, -1, 1.0f));
                            eVar.a().clear();
                            eVar.a().add(aVar2);
                        } else {
                            g(sb.toString());
                        }
                    }
                }
            }
        }
    }

    public final void C(c.a.v0.h.c cVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (cVar == null || h.b(cVar.c()) < 2) {
                str = "mixAudio tempDataForOutPut data error";
            } else {
                List<c.a.v0.h.e> c2 = cVar.c();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                for (c.a.v0.h.e eVar : c2) {
                    if (eVar != null && !h.e(eVar.a())) {
                        c.a.v0.h.a aVar = eVar.a().get(0);
                        if (aVar.b() != null) {
                            arrayList.add(aVar.b().audioPath);
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    String str2 = this.f21570g;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = FileUtils.getParentDir((String) arrayList.get(0));
                    }
                    String str3 = str2 + System.currentTimeMillis() + "_mix.aac";
                    f.k(arrayList, str3, -1, new e(this, sb));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb.append(e2.getMessage());
                    }
                    if (!FileUtils.isExists(str3) || !TextUtils.isEmpty(sb.toString())) {
                        g(sb.toString());
                        return;
                    }
                    c.a.v0.r.c.j("FFmpegChain", "mixAudio 生成成功");
                    c.a.v0.h.a aVar2 = new c.a.v0.h.a(new AudioPlayData(str3, 0, -1, 1.0f));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(aVar2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new c.a.v0.h.e(arrayList2));
                    this.r = new c.a.v0.h.c(arrayList3);
                    return;
                }
                str = "mixAudio inputList data error";
            }
            g(str);
        }
    }

    @Override // c.a.v0.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21569f = true;
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // c.a.v0.h.f.a
    public void d(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("input data error: null or length=0");
                return;
            }
            this.m = false;
            this.n = false;
            this.p = false;
            this.q = false;
            if (!j(cVar)) {
                l(cVar);
                return;
            }
            String a2 = cVar.a();
            this.f21570g = a2;
            if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f21570g)) {
                new File(this.f21570g).mkdir();
            }
            this.f21568e = false;
            this.f21569f = false;
            this.k = cVar.b();
            x(cVar);
            y(cVar);
            this.i = 0;
            if (this.m && !this.f21569f && !this.f21568e) {
                A();
            }
            if (this.n && !this.f21569f && !this.f21568e) {
                this.i = 10;
                i(10);
                z(cVar);
            }
            if (this.p && !this.f21569f && !this.f21568e) {
                this.i = 70;
                i(70);
                B(this.r);
            }
            if (this.q && !this.f21569f && !this.f21568e) {
                this.i = 80;
                i(80);
                C(this.r);
            }
            if (this.f21568e || this.f21569f) {
                return;
            }
            l(this.r);
        }
    }

    @Override // c.a.v0.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void q(c.a.v0.h.a aVar, int i) {
        int i2;
        c.a.v0.h.a aVar2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i) == null) || this.f21568e || this.f21569f) {
            return;
        }
        AudioPlayData b2 = aVar.b();
        if (b2 == null) {
            sb = new StringBuilder();
            str = "dealAudioPlayData audioPlayData = null,trackIndx:";
        } else if (this.o != null) {
            if (!aVar.c() && (aVar2 = this.k) != null && aVar2.b() != null) {
                b2.audioPath = this.k.b().audioPath;
                aVar.d(this.k.a());
            }
            StringBuilder sb2 = new StringBuilder();
            String str2 = b2.audioPath;
            String a2 = a(str2, System.currentTimeMillis() + "_ffmpeg.aac");
            try {
                boolean z = aVar.a() != null && "audio/mp4a-latm".equals(aVar.a().f());
                String str3 = b2.audioPath;
                int g2 = this.o.g();
                int d2 = this.o.d();
                float f2 = b2.volume;
                int c2 = this.o.c();
                float f3 = (b2.start * 1.0f) / 1000.0f;
                float f4 = ((b2.end - b2.start) * 1.0f) / 1000.0f;
                i2 = 0;
                try {
                    f.l(str3, a2, g2, d2, f2, c2, f3, f4, !z, new c(this, sb2, aVar));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb2.append(e2.getMessage());
                    }
                } catch (Throwable th) {
                    th = th;
                    sb2.append(th.getMessage());
                    if (FileUtils.isExists(a2)) {
                    }
                    g(sb2.toString());
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 0;
            }
            if (FileUtils.isExists(a2) || !TextUtils.isEmpty(sb2.toString())) {
                g(sb2.toString());
                return;
            }
            c.a.v0.r.c.j("FFmpegChain", "dealAudioPlayData 生成成功");
            r(this.r, new c.a.v0.h.a(new AudioPlayData(a2, i2, -1, 1.0f)), i);
            return;
        } else {
            sb = new StringBuilder();
            str = "dealAudioPlayData mTargetInfo = null ,trackIndx:";
        }
        sb.append(str);
        sb.append(i);
        g(sb.toString());
    }

    public final void r(c.a.v0.h.c cVar, c.a.v0.h.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, cVar, aVar, i) == null) || cVar == null || cVar.c() == null || cVar.c().get(i) == null) {
            return;
        }
        cVar.c().get(i).a().add(aVar);
    }

    public final void s(c.a.v0.h.e eVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, i) == null) || eVar == null || h.e(eVar.a()) || this.f21569f || this.f21568e) {
            return;
        }
        for (int i2 = 0; !this.f21568e && !this.f21569f && i2 < eVar.a().size(); i2++) {
            c.a.v0.h.a aVar = eVar.a().get(i2);
            this.j++;
            if (v(aVar)) {
                q(aVar, i);
            } else {
                r(this.r, aVar, i);
                i(this.i + ((int) (((this.j * 1.0f) / this.f21571h) * 60.0f)));
            }
        }
    }

    public final boolean t(c.a.v0.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, aVar)) == null) {
            if (aVar == null || aVar.b() == null || !FileUtils.isExists(aVar.b().audioPath)) {
                return false;
            }
            if (aVar.b().start <= 0 && aVar.b().end <= 0 && aVar.b().volume == 1.0f) {
                return (aVar.a() == null || "audio/mp4a-latm".equals(aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(c.a.v0.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            return t(aVar) || aVar.a() == null || aVar.a().k(this.o) != 0;
        }
        return invokeL.booleanValue;
    }

    public final void x(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            List<c.a.v0.h.e> c2 = cVar.c();
            HashMap hashMap = new HashMap();
            if (c2.size() > 1) {
                this.q = true;
            }
            int i = 0;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (!h.e(c2.get(i2).a())) {
                    this.f21571h += h.b(c2.get(i2).a());
                    List<c.a.v0.h.a> a2 = c2.get(i2).a();
                    if (!h.e(a2)) {
                        if (a2.size() > 1) {
                            this.p = true;
                        }
                        for (c.a.v0.h.a aVar : a2) {
                            if (aVar != null && aVar.b() != null && !aVar.c()) {
                                long j = aVar.b().end - aVar.b().start;
                                if (j > this.l) {
                                    this.l = j;
                                }
                                this.m = true;
                                this.n = true;
                            }
                            if (t(aVar)) {
                                this.n = true;
                            }
                            if (aVar != null && aVar.a() != null) {
                                Integer num = (Integer) hashMap.get(aVar.a());
                                if (num == null) {
                                    num = 0;
                                }
                                hashMap.put(aVar.a(), Integer.valueOf(num.intValue() + 1));
                            }
                        }
                    }
                }
            }
            if (hashMap.size() > 1) {
                this.n = true;
            }
            for (c.a.v0.h.b bVar : hashMap.keySet()) {
                if (((Integer) hashMap.get(bVar)).intValue() > i && "audio/mp4a-latm".equals(bVar.f())) {
                    this.o = bVar;
                    i = ((Integer) hashMap.get(bVar)).intValue();
                }
            }
            if (this.o == null) {
                this.o = c.a.v0.h.b.b();
            }
        }
    }

    public final void y(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.n) {
                if (cVar == null || h.e(cVar.c())) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < cVar.c().size(); i++) {
                    arrayList.add(new c.a.v0.h.e(new ArrayList()));
                }
                cVar = new c.a.v0.h.c(arrayList);
            }
            this.r = cVar;
        }
    }

    public final void z(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            List<c.a.v0.h.e> c2 = cVar.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                s(c2.get(i), i);
            }
        }
    }
}
