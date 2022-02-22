package c.a.b1.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.b1.l.d.f;
import c.a.b1.s.a;
import c.a.b1.t.h;
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
/* loaded from: classes.dex */
public class b extends c.a.b1.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f1189h;

    /* renamed from: i  reason: collision with root package name */
    public int f1190i;

    /* renamed from: j  reason: collision with root package name */
    public int f1191j;
    public c.a.b1.h.a k;
    public long l;
    public boolean m;
    public boolean n;
    public c.a.b1.h.b o;
    public boolean p;
    public boolean q;
    public c.a.b1.h.c r;

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0031a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1192b;

        public a(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1192b = bVar;
            this.a = sb;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1192b) {
                    this.f1192b.notifyAll();
                }
            }
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",createMuteAudio ffmpegerror:");
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i3);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.b1.t.c.j("FFmpegChain", sb2);
                synchronized (this.f1192b) {
                    this.f1192b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                if (i2 != 1001 || i3 < 0) {
                    return false;
                }
                c.a.b1.t.c.j("FFmpegChain", " createMuteAudio 进度i1 = " + i3);
                b bVar = this.f1192b;
                bVar.i((int) (((float) bVar.f1190i) + (((((float) i3) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* renamed from: c.a.b1.h.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0014b implements a.InterfaceC0031a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1193b;

        public C0014b(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1193b = bVar;
            this.a = sb;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1193b) {
                    this.f1193b.notifyAll();
                }
            }
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",concatAudio ffmpegerror:");
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i3);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.b1.t.c.j("FFmpegChain", sb2);
                synchronized (this.f1193b) {
                    this.f1193b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                c.a.b1.t.c.j("FFmpegChain", " concatMuteAudio 进度i1 = " + i3);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0031a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.b1.h.a f1194b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f1195c;

        public c(b bVar, StringBuilder sb, c.a.b1.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1195c = bVar;
            this.a = sb;
            this.f1194b = aVar;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1195c) {
                    this.f1195c.notifyAll();
                }
            }
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",dealAudioPlayData ffmpegerror:");
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i3);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.b1.h.a aVar = this.f1194b;
                if (aVar != null && aVar.a() != null) {
                    this.a.append(",audioformat:");
                    this.a.append(this.f1194b.a().f());
                    this.a.append(",audiopath:");
                    this.a.append(this.f1194b.a().h());
                }
                c.a.b1.t.c.j("FFmpegChain", sb2);
                synchronized (this.f1195c) {
                    this.f1195c.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                if (i2 != 1001 || i3 < 0) {
                    return false;
                }
                c.a.b1.t.c.j("FFmpegChain", " dealAudioPlayData 进度i1 = " + i3);
                b bVar = this.f1195c;
                bVar.i(bVar.f1190i + ((int) ((((((float) (this.f1195c.f1191j + (-1))) + ((((float) i3) * 1.0f) / 100.0f)) * 1.0f) / ((float) this.f1195c.f1189h)) * 60.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.InterfaceC0031a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1196b;

        public d(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1196b = bVar;
            this.a = sb;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1196b) {
                    this.f1196b.notifyAll();
                }
            }
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("concatAudio ffmpegerror:");
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i3);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.b1.t.c.j("FFmpegChain", sb2);
                synchronized (this.f1196b) {
                    this.f1196b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                if (i2 != 1001 || i3 < 0) {
                    return false;
                }
                c.a.b1.t.c.j("FFmpegChain", " concatAudio 进度i1 = " + i3);
                b bVar = this.f1196b;
                bVar.i((int) (((float) bVar.f1190i) + (((((float) i3) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.InterfaceC0031a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f1197b;

        public e(b bVar, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1197b = bVar;
            this.a = sb;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f1197b) {
                    this.f1197b.notifyAll();
                }
            }
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("mixAudio ffmpegerror:");
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i3);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                c.a.b1.t.c.j("FFmpegChain", sb2);
                synchronized (this.f1197b) {
                    this.f1197b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // c.a.b1.s.a.InterfaceC0031a
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, obj)) == null) {
                if (i2 != 1001 || i3 < 0) {
                    return false;
                }
                c.a.b1.t.c.j("FFmpegChain", " mixAudio 进度i1 = " + i3);
                b bVar = this.f1197b;
                bVar.i((int) (((float) bVar.f1190i) + (((((float) i3) * 1.0f) / 100.0f) * 20.0f)));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void A() {
        String str;
        String a2;
        c.a.b1.h.b bVar;
        c.a.b1.h.a aVar;
        c.a.b1.h.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.b1.h.a aVar2 = this.k;
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
                    c.a.b1.t.c.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                    this.k = new c.a.b1.h.a(new AudioPlayData(a2, 0, -1, 1.0f));
                    return;
                }
                g(sb.toString());
            }
            c.a.b1.h.a aVar3 = this.k;
            str = aVar3 != null ? aVar3.a().h() : "";
            i(this.f1190i + 10);
            if (FileUtils.isExists(str) && TextUtils.isEmpty(sb.toString())) {
                c.a.b1.t.c.j("FFmpegChain", "createMuteAudio 生成成功");
                c.a.b1.h.a aVar4 = new c.a.b1.h.a(new AudioPlayData(str, 0, -1, 1.0f));
                this.k = aVar4;
                if (aVar4.a() == null || this.k.a().e() <= 0) {
                    return;
                }
                long e3 = this.k.a().e();
                long j2 = this.l;
                if (e3 >= j2) {
                    return;
                }
                int e4 = (int) ((j2 / this.k.a().e()) + 1);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < e4; i2++) {
                    arrayList.add(str);
                }
                a2 = a(str, "_concat.aac");
                f.b(arrayList, a2, this.f1188g, new C0014b(this, sb), false, true);
                try {
                } catch (InterruptedException e5) {
                    sb.append(e5.getMessage());
                }
                synchronized (this) {
                    wait();
                    if (FileUtils.isExists(a2)) {
                        c.a.b1.t.c.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                        this.k = new c.a.b1.h.a(new AudioPlayData(a2, 0, -1, 1.0f));
                        return;
                    }
                }
            }
            g(sb.toString());
        }
    }

    public final void B(c.a.b1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("concatAudio tempDataForOutPut data error");
                return;
            }
            List<c.a.b1.h.e> c2 = cVar.c();
            StringBuilder sb = new StringBuilder();
            for (c.a.b1.h.e eVar : c2) {
                if (!h.e(eVar.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (c.a.b1.h.a aVar : eVar.a()) {
                        if (aVar.b() != null) {
                            arrayList.add(aVar.b().audioPath);
                        }
                    }
                    if (!h.e(arrayList)) {
                        String str = this.f1188g;
                        if (TextUtils.isEmpty(str)) {
                            str = FileUtils.getParentDir((String) arrayList.get(0));
                        }
                        String str2 = str + System.currentTimeMillis() + "_trackconcat.aac";
                        f.b(arrayList, str2, this.f1188g, new d(this, sb), false, true);
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e2) {
                            sb.append(e2.getMessage());
                        }
                        if (FileUtils.isExists(str2) && TextUtils.isEmpty(sb.toString())) {
                            c.a.b1.t.c.j("FFmpegChain", "concatAudio 生成成功");
                            c.a.b1.h.a aVar2 = new c.a.b1.h.a(new AudioPlayData(str2, 0, -1, 1.0f));
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

    public final void C(c.a.b1.h.c cVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (cVar == null || h.b(cVar.c()) < 2) {
                str = "mixAudio tempDataForOutPut data error";
            } else {
                List<c.a.b1.h.e> c2 = cVar.c();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                for (c.a.b1.h.e eVar : c2) {
                    if (eVar != null && !h.e(eVar.a())) {
                        c.a.b1.h.a aVar = eVar.a().get(0);
                        if (aVar.b() != null) {
                            arrayList.add(aVar.b().audioPath);
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    String str2 = this.f1188g;
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
                    c.a.b1.t.c.j("FFmpegChain", "mixAudio 生成成功");
                    c.a.b1.h.a aVar2 = new c.a.b1.h.a(new AudioPlayData(str3, 0, -1, 1.0f));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(aVar2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new c.a.b1.h.e(arrayList2));
                    this.r = new c.a.b1.h.c(arrayList3);
                    return;
                }
                str = "mixAudio inputList data error";
            }
            g(str);
        }
    }

    @Override // c.a.b1.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1187f = true;
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // c.a.b1.h.f.a
    public void d(c.a.b1.h.c cVar) {
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
            this.f1188g = a2;
            if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f1188g)) {
                new File(this.f1188g).mkdir();
            }
            this.f1186e = false;
            this.f1187f = false;
            this.k = cVar.b();
            x(cVar);
            y(cVar);
            this.f1190i = 0;
            if (this.m && !this.f1187f && !this.f1186e) {
                A();
            }
            if (this.n && !this.f1187f && !this.f1186e) {
                this.f1190i = 10;
                i(10);
                z(cVar);
            }
            if (this.p && !this.f1187f && !this.f1186e) {
                this.f1190i = 70;
                i(70);
                B(this.r);
            }
            if (this.q && !this.f1187f && !this.f1186e) {
                this.f1190i = 80;
                i(80);
                C(this.r);
            }
            if (this.f1186e || this.f1187f) {
                return;
            }
            l(this.r);
        }
    }

    @Override // c.a.b1.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void q(c.a.b1.h.a aVar, int i2) {
        int i3;
        c.a.b1.h.a aVar2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f1186e || this.f1187f) {
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
                i3 = 0;
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
                i3 = 0;
            }
            if (FileUtils.isExists(a2) || !TextUtils.isEmpty(sb2.toString())) {
                g(sb2.toString());
                return;
            }
            c.a.b1.t.c.j("FFmpegChain", "dealAudioPlayData 生成成功");
            r(this.r, new c.a.b1.h.a(new AudioPlayData(a2, i3, -1, 1.0f)), i2);
            return;
        } else {
            sb = new StringBuilder();
            str = "dealAudioPlayData mTargetInfo = null ,trackIndx:";
        }
        sb.append(str);
        sb.append(i2);
        g(sb.toString());
    }

    public final void r(c.a.b1.h.c cVar, c.a.b1.h.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, cVar, aVar, i2) == null) || cVar == null || cVar.c() == null || cVar.c().get(i2) == null) {
            return;
        }
        cVar.c().get(i2).a().add(aVar);
    }

    public final void s(c.a.b1.h.e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, i2) == null) || eVar == null || h.e(eVar.a()) || this.f1187f || this.f1186e) {
            return;
        }
        for (int i3 = 0; !this.f1186e && !this.f1187f && i3 < eVar.a().size(); i3++) {
            c.a.b1.h.a aVar = eVar.a().get(i3);
            this.f1191j++;
            if (v(aVar)) {
                q(aVar, i2);
            } else {
                r(this.r, aVar, i2);
                i(this.f1190i + ((int) (((this.f1191j * 1.0f) / this.f1189h) * 60.0f)));
            }
        }
    }

    public final boolean t(c.a.b1.h.a aVar) {
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

    public final boolean v(c.a.b1.h.a aVar) {
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

    public final void x(c.a.b1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            List<c.a.b1.h.e> c2 = cVar.c();
            HashMap hashMap = new HashMap();
            if (c2.size() > 1) {
                this.q = true;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < c2.size(); i3++) {
                if (!h.e(c2.get(i3).a())) {
                    this.f1189h += h.b(c2.get(i3).a());
                    List<c.a.b1.h.a> a2 = c2.get(i3).a();
                    if (!h.e(a2)) {
                        if (a2.size() > 1) {
                            this.p = true;
                        }
                        for (c.a.b1.h.a aVar : a2) {
                            if (aVar != null && aVar.b() != null && !aVar.c()) {
                                long j2 = aVar.b().end - aVar.b().start;
                                if (j2 > this.l) {
                                    this.l = j2;
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
            for (c.a.b1.h.b bVar : hashMap.keySet()) {
                if (((Integer) hashMap.get(bVar)).intValue() > i2 && "audio/mp4a-latm".equals(bVar.f())) {
                    this.o = bVar;
                    i2 = ((Integer) hashMap.get(bVar)).intValue();
                }
            }
            if (this.o == null) {
                this.o = c.a.b1.h.b.b();
            }
        }
    }

    public final void y(c.a.b1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.n) {
                if (cVar == null || h.e(cVar.c())) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < cVar.c().size(); i2++) {
                    arrayList.add(new c.a.b1.h.e(new ArrayList()));
                }
                cVar = new c.a.b1.h.c(arrayList);
            }
            this.r = cVar;
        }
    }

    public final void z(c.a.b1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            List<c.a.b1.h.e> c2 = cVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                s(c2.get(i2), i2);
            }
        }
    }
}
