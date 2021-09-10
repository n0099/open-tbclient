package c.a.r0.f0.a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.f0.a.a;
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
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.gson.Gson;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements c.a.r0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17485a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f17486b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f17487c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f17488d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.p0.a.a f17489e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17490f;

    /* renamed from: g  reason: collision with root package name */
    public List<MultiMediaData> f17491g;

    /* renamed from: h  reason: collision with root package name */
    public float f17492h;

    /* renamed from: i  reason: collision with root package name */
    public int f17493i;

    /* renamed from: j  reason: collision with root package name */
    public int f17494j;

    /* loaded from: classes3.dex */
    public class a implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17495a;

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
            this.f17495a = bVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17495a.f17486b == null) {
                return;
            }
            this.f17495a.f17486b.start();
        }
    }

    /* renamed from: c.a.r0.f0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0853b implements c.a.x0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17496a;

        public C0853b(b bVar) {
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
            this.f17496a = bVar;
        }

        @Override // c.a.x0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.r0.b4.l.b(this.f17496a.f17485a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17496a.f17490f ? c.a.r0.x3.c.f28882c : c.a.r0.x3.c.f28883d : (String) invokeV.objValue;
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
        public final /* synthetic */ a.InterfaceC0852a f17497a;

        public d(b bVar, a.InterfaceC0852a interfaceC0852a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, interfaceC0852a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17497a = interfaceC0852a;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                this.f17497a.a();
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onStart();
                this.f17497a.b();
            }
        }
    }

    public b(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, TbMultiMediaData tbMultiMediaData, c.a.r0.p0.a.a aVar, boolean z) {
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
        this.f17490f = false;
        this.f17485a = tbPageContext;
        this.f17488d = tbGLMediaPreviewView;
        ArrayList arrayList = new ArrayList();
        this.f17491g = arrayList;
        arrayList.add(tbMultiMediaData);
        this.f17489e = aVar;
        this.f17490f = z;
        l();
    }

    @Override // c.a.r0.f0.a.a
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
            VlogEditManager vlogEditManager = this.f17486b;
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

    @Override // c.a.r0.f0.a.a
    public void b(a.InterfaceC0852a interfaceC0852a) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0852a) == null) || (vlogEditManager = this.f17486b) == null) {
            return;
        }
        vlogEditManager.setOnPlayStateListener(null);
        this.f17486b.setOnPlayStateListener(new d(this, interfaceC0852a));
    }

    @Override // c.a.r0.f0.a.a
    public void c(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.f17491g.clear();
        this.f17491g.add(tbMultiMediaData);
        p();
    }

    @Override // c.a.r0.f0.a.a
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.f0.a.a
    public void e(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048580, this, f2) == null) || this.f17492h == f2) {
            return;
        }
        this.f17492h = f2;
        k();
        VlogEditManager vlogEditManager = this.f17486b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f17486b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // c.a.r0.f0.a.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.f0.a.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    @Override // c.a.r0.f0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.f0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f17486b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f17486b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // c.a.r0.f0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f17492h : invokeV.floatValue;
    }

    @Override // c.a.r0.f0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            VlogEditManager vlogEditManager = this.f17486b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || !(this.f17488d.getLayoutParams() instanceof FrameLayout.LayoutParams) || ListUtils.isEmpty(this.f17491g) || this.f17491g.get(0) == null || this.f17491g.get(0).height <= 0 || this.f17491g.get(0).width <= 0) {
            return;
        }
        TbGLMediaPreviewView tbGLMediaPreviewView = this.f17488d;
        if (tbGLMediaPreviewView != null) {
            ViewGroup.LayoutParams layoutParams = tbGLMediaPreviewView.getLayoutParams();
            float f2 = this.f17492h;
            if (f2 > 1.0f) {
                layoutParams.width = Math.min((int) (this.f17493i / f2), this.f17494j);
            } else if (f2 > 0.0f) {
                layoutParams.width = this.f17494j;
            }
            layoutParams.height = (int) (layoutParams.width * this.f17492h);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            this.f17488d.setTranslationY(((this.f17493i + statusBarHeight) - layoutParams.height) * 0.5f);
            this.f17488d.setTranslationX((this.f17494j - layoutParams.width) * 0.5f);
            this.f17488d.requestLayout();
        }
        this.f17486b.setVideoRatio(this.f17492h);
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!c.a.r0.w3.a.a()) {
                this.f17485a.getPageActivity().finish();
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
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f17488d.setZOrderMediaOverlay(true);
            this.f17488d.setMultiMediaDataSourceViewAdapter(this.f17487c, false);
            this.f17488d.setCanMeasure(false);
            this.f17493i = l.i(this.f17485a.getPageActivity());
            this.f17494j = l.k(this.f17485a.getPageActivity());
            k();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.x0.b.d().i(TbadkCoreApplication.getInst());
            c.a.x0.b.d().k(FileHelper.getCacheDir());
            c.a.x0.b.d().l(new C0853b(this));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f17487c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f17486b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.f17491g);
            this.f17486b.setLooping(true);
            this.f17486b.setPreparedListener(new a(this));
            c.a.r0.p0.a.a aVar = this.f17489e;
            if (aVar != null) {
                aVar.c(this.f17486b, this.f17487c);
            }
        }
    }

    @Override // c.a.r0.f0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            VlogEditManager vlogEditManager = this.f17486b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17488d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            c.a.r0.p0.a.a aVar = this.f17489e;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    @Override // c.a.r0.f0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            VlogEditManager vlogEditManager = this.f17486b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17488d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // c.a.r0.f0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17488d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f17486b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    public final void p() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (vlogEditManager = this.f17486b) == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f17486b.reset();
        this.f17486b.setMultiMediaData(this.f17491g);
        if (isPlaying) {
            this.f17486b.start();
        } else {
            this.f17486b.pause();
        }
    }

    @Override // c.a.r0.f0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (vlogEditManager = this.f17486b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // c.a.r0.f0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (vlogEditManager = this.f17486b) == null) {
            return;
        }
        vlogEditManager.start();
    }
}
