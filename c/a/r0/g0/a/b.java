package c.a.r0.g0.a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.g0.a.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener;
import com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol;
import com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.gson.Gson;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements c.a.r0.g0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17661a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f17662b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f17663c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f17664d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.q0.a.a f17665e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17666f;

    /* renamed from: g  reason: collision with root package name */
    public List<MultiMediaData> f17667g;

    /* renamed from: h  reason: collision with root package name */
    public float f17668h;

    /* renamed from: i  reason: collision with root package name */
    public int f17669i;

    /* renamed from: j  reason: collision with root package name */
    public int f17670j;

    /* loaded from: classes3.dex */
    public class a implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17671a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17671a = bVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17671a.f17662b == null) {
                return;
            }
            this.f17671a.f17662b.start();
        }
    }

    /* renamed from: c.a.r0.g0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0860b implements c.a.x0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17672a;

        public C0860b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17672a = bVar;
        }

        @Override // c.a.x0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.r0.c4.l.b(this.f17672a.f17661a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17672a.f17666f ? c.a.r0.y3.c.f29078c : c.a.r0.y3.c.f29079d : (String) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public c.a.x0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (c.a.x0.j.a) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends IVLogPlayControlProtocol.OnPlayStateListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0859a f17673a;

        public d(b bVar, a.InterfaceC0859a interfaceC0859a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC0859a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17673a = interfaceC0859a;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                a.InterfaceC0859a interfaceC0859a = this.f17673a;
                if (interfaceC0859a != null) {
                    interfaceC0859a.a();
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSeek(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                super.onSeek(j2);
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSetIsLoop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                super.onSetIsLoop(z);
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSpeedChanged(float f2, MultiMediaData multiMediaData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), multiMediaData}) == null) {
                super.onSpeedChanged(f2, multiMediaData);
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onStart();
                a.InterfaceC0859a interfaceC0859a = this.f17673a;
                if (interfaceC0859a != null) {
                    interfaceC0859a.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0859a f17674a;

        public e(b bVar, a.InterfaceC0859a interfaceC0859a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC0859a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17674a = interfaceC0859a;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onIndexChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onLoop() {
            a.InterfaceC0859a interfaceC0859a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (interfaceC0859a = this.f17674a) == null) {
                return;
            }
            interfaceC0859a.b();
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexLoop(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    public b(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, TbMultiMediaData tbMultiMediaData, c.a.r0.q0.a.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, tbMultiMediaData, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17666f = false;
        this.f17661a = tbPageContext;
        this.f17664d = tbGLMediaPreviewView;
        ArrayList arrayList = new ArrayList();
        this.f17667g = arrayList;
        arrayList.add(tbMultiMediaData);
        this.f17665e = aVar;
        this.f17666f = z;
        l();
    }

    @Override // c.a.r0.g0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            String str = IVlogEditManager.FILTER_ORIGINAL;
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.localPath) || FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                f2 = 0.0f;
            } else {
                f2 = c.a.e.e.m.b.d(qmFilterItem.effect, 100.0f) / 100.0f;
                File file = new File(qmFilterItem.localPath);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new c(this));
                    if (listFiles.length > 0) {
                        str = listFiles[0].getAbsolutePath();
                    }
                }
            }
            VlogEditManager vlogEditManager = this.f17662b;
            if (vlogEditManager != null) {
                try {
                    vlogEditManager.setFilter(f2, str);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.g0.a.a
    public void b(a.InterfaceC0859a interfaceC0859a) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0859a) == null) || (vlogEditManager = this.f17662b) == null) {
            return;
        }
        vlogEditManager.setOnPlayStateListener(null);
        this.f17662b.setOnPlayStateListener(new d(this, interfaceC0859a));
        this.f17662b.setMultiMediaStateEventListener(null);
        this.f17662b.setMultiMediaStateEventListener(new e(this, interfaceC0859a));
    }

    @Override // c.a.r0.g0.a.a
    public void c(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.f17667g.clear();
        this.f17667g.add(tbMultiMediaData);
        p();
    }

    @Override // c.a.r0.g0.a.a
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.g0.a.a
    public void e(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || this.f17668h == f2) {
            return;
        }
        this.f17668h = f2;
        k();
        VlogEditManager vlogEditManager = this.f17662b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f17662b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // c.a.r0.g0.a.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.g0.a.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    @Override // c.a.r0.g0.a.a
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VlogEditManager vlogEditManager = this.f17662b;
            if (vlogEditManager != null) {
                return vlogEditManager.getCurrentPlayTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.g0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.g0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f17662b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f17662b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // c.a.r0.g0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f17668h : invokeV.floatValue;
    }

    @Override // c.a.r0.g0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            VlogEditManager vlogEditManager = this.f17662b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || !(this.f17664d.getLayoutParams() instanceof FrameLayout.LayoutParams) || ListUtils.isEmpty(this.f17667g) || this.f17667g.get(0) == null || this.f17667g.get(0).height <= 0 || this.f17667g.get(0).width <= 0) {
            return;
        }
        TbGLMediaPreviewView tbGLMediaPreviewView = this.f17664d;
        if (tbGLMediaPreviewView != null) {
            ViewGroup.LayoutParams layoutParams = tbGLMediaPreviewView.getLayoutParams();
            float f2 = this.f17668h;
            if (f2 > 1.0f) {
                layoutParams.width = Math.min((int) (this.f17669i / f2), this.f17670j);
            } else if (f2 > 0.0f) {
                layoutParams.width = this.f17670j;
            }
            layoutParams.height = (int) (layoutParams.width * this.f17668h);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            this.f17664d.setTranslationY(((this.f17669i + statusBarHeight) - layoutParams.height) * 0.5f);
            this.f17664d.setTranslationX((this.f17670j - layoutParams.width) * 0.5f);
            this.f17664d.requestLayout();
        }
        this.f17662b.setVideoRatio(this.f17668h);
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!c.a.r0.x3.a.a()) {
                this.f17661a.getPageActivity().finish();
                return false;
            }
            n();
            o();
            m();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f17664d.setZOrderMediaOverlay(true);
            this.f17664d.setMultiMediaDataSourceViewAdapter(this.f17663c, false);
            this.f17664d.setCanMeasure(false);
            this.f17669i = l.i(this.f17661a.getPageActivity());
            this.f17670j = l.k(this.f17661a.getPageActivity());
            k();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.x0.b.d().i(TbadkCoreApplication.getInst());
            c.a.x0.b.d().k(FileHelper.getCacheDir());
            c.a.x0.b.d().l(new C0860b(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f17663c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f17662b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.f17667g);
            this.f17662b.setLooping(true);
            this.f17662b.setPreparedListener(new a(this));
            c.a.r0.q0.a.a aVar = this.f17665e;
            if (aVar != null) {
                aVar.c(this.f17662b, this.f17663c);
            }
        }
    }

    @Override // c.a.r0.g0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            VlogEditManager vlogEditManager = this.f17662b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17664d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            c.a.r0.q0.a.a aVar = this.f17665e;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    @Override // c.a.r0.g0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            VlogEditManager vlogEditManager = this.f17662b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17664d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // c.a.r0.g0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17664d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f17662b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    public final void p() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (vlogEditManager = this.f17662b) == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f17662b.reset();
        this.f17662b.setMultiMediaData(this.f17667g);
        if (isPlaying) {
            this.f17662b.start();
        } else {
            this.f17662b.pause();
        }
    }

    @Override // c.a.r0.g0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (vlogEditManager = this.f17662b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // c.a.r0.g0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (vlogEditManager = this.f17662b) == null) {
            return;
        }
        vlogEditManager.start();
    }
}
