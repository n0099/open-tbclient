package c.a.r0.q0.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.q0.a.g.b;
import c.a.r0.x3.h;
import c.a.x0.t.t;
import c.a.x0.t.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tieba.R;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.sticker.OnChangeStickerListener;
import java.io.File;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements c.a.r0.q0.a.a, PreViewPickCoverView.e, c.a.r0.c4.l.d.a, OnChangeStickerListener, c.a.r0.q0.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f23597e;

    /* renamed from: f  reason: collision with root package name */
    public VlogEditManager f23598f;

    /* renamed from: g  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f23599g;

    /* renamed from: h  reason: collision with root package name */
    public TbGLMediaPreviewView f23600h;

    /* renamed from: i  reason: collision with root package name */
    public PreViewPickCoverView f23601i;

    /* renamed from: j  reason: collision with root package name */
    public float f23602j;
    public float k;
    public TbMultiMediaData l;
    public List<MultiMediaData> m;
    public h n;
    public MultiMediaData o;
    public MultiMediaData p;
    public TextWordsEntity q;
    public ArrayList<IEffectProcessor> r;
    public ArrayList<IMediaRenderer> s;
    public c.a.r0.q0.a.c t;
    public c.a.r0.q0.a.b u;
    @Nullable
    public List<MultiMediaData> v;

    /* loaded from: classes3.dex */
    public class a implements MultiMediaDataSourceViewAdapter.OnMultiMediaDataTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter.OnMultiMediaDataTextureListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f23603e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f23604f;

        public b(d dVar, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23604f = dVar;
            this.f23603e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23604f.n.c(this.f23603e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23605e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23605e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23605e.A();
            }
        }
    }

    /* renamed from: c.a.r0.q0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1099d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23606e;

        public RunnableC1099d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23606e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Buffer captureVideoCover;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (captureVideoCover = this.f23606e.f23598f.captureVideoCover(this.f23606e.f23598f.getCurrentIndex(), this.f23606e.f23598f.getCurrentPlayTime(), this.f23606e.f23600h.getWidth(), this.f23606e.f23600h.getHeight())) == null) {
                return;
            }
            d dVar = this.f23606e;
            dVar.C(captureVideoCover, dVar.f23600h.getWidth(), this.f23606e.f23600h.getHeight());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23607e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f23608e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f23609f;

            public a(e eVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23609f = eVar;
                this.f23608e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23609f.f23607e.f23601i == null) {
                    return;
                }
                this.f23609f.f23607e.f23601i.updateVideoCover(this.f23608e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f23610e;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23610e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f23610e.f23607e.f23601i.hideCoverImage();
                }
            }
        }

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23607e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23607e.f23598f != null && this.f23607e.f23598f.isPaused()) {
                if (this.f23607e.p != null) {
                    u.a().post(new a(this, BitmapFactory.decodeFile(this.f23607e.p.path)));
                    return;
                }
                u.a().post(new b(this));
            }
        }
    }

    public d(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, PreViewPickCoverView preViewPickCoverView, TbMultiMediaData tbMultiMediaData, boolean z) {
        File CreateFileIfNotFound;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, preViewPickCoverView, tbMultiMediaData, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23597e = tbPageContext;
        this.f23600h = tbGLMediaPreviewView;
        this.f23601i = preViewPickCoverView;
        this.m = new ArrayList();
        this.l = tbMultiMediaData;
        try {
            TextWordsEntity parse = TextWordsEntity.parse(new JSONObject("{\"style\":[{\"id\":\"1\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328775756\\/1.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"shadow_infos\":[{\"color\":\"000000\",\"alpha\":\"0.4\",\"width\":\"1\",\"offset_x\":\"0\",\"offset_y\":\"2\",\"blur\":\"4\"}],\"type\":1},{\"id\":\"17\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328785140\\/2.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"000000\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":2},{\"id\":\"18\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328796132\\/3.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"E44A41\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"226EEA\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":3},{\"id\":\"4\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328806597\\/4.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"000000\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599034626568\\/%E6%A0%B7%E5%BC%8F%E4%B8%80%20copy%403x.png\",\"left\":24,\"right\":51,\"top\":111,\"bottom\":40,\"stretchableX\":[{\"start\":160,\"stop\":230}],\"stretchableY\":[{\"start\":100,\"stop\":170}],\"width\":228,\"imageType\":3},\"type\":3},{\"id\":\"5\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328817830\\/5.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"393939\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599037658846\\/%E6%A0%B7%E5%BC%8F%E4%BA%8C%20copy%403x.png\",\"left\":64,\"right\":118,\"top\":62,\"bottom\":61,\"stretchableX\":[{\"start\":120,\"stop\":220}],\"stretchableY\":[{\"start\":64,\"stop\":67}],\"width\":423,\"imageType\":3},\"type\":3},{\"id\":\"6\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328828185\\/6.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"393939\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599037845877\\/%E6%A0%B7%E5%BC%8F%E4%B8%89%20copy%403x.png\",\"left\":54,\"right\":23,\"top\":41,\"bottom\":84,\"stretchableX\":[{\"start\":250,\"stop\":300}],\"stretchableY\":[{\"start\":50,\"stop\":100}],\"width\":366,\"imageType\":3},\"type\":3},{\"id\":\"2\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328839826\\/7.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"F6B700\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"000000\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":3},{\"id\":\"19\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328850600\\/8.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"000000\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"000000\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":2},{\"id\":\"20\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328861049\\/9.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"F5B47A\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"E44A41\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":3},{\"id\":\"7\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328878943\\/10.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"1C2045\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599046528732\\/%E6%A0%B7%E5%BC%8F%E5%9B%9B%20copy%403x.png\",\"left\":61,\"right\":61,\"top\":69,\"bottom\":52,\"stretchableX\":[{\"start\":80,\"stop\":180}],\"stretchableY\":[{\"start\":60,\"stop\":110}],\"width\":399,\"imageType\":3},\"type\":3},{\"id\":\"8\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328889391\\/11.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"D21D1D\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038226204\\/%E6%A0%B7%E5%BC%8F%E4%BA%94%20copy%403x.png\",\"left\":42,\"right\":42,\"top\":37,\"bottom\":37,\"stretchableX\":[{\"start\":75,\"stop\":175}],\"stretchableY\":[{\"start\":45,\"stop\":95}],\"width\":366,\"imageType\":3},\"type\":3},{\"id\":\"9\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328899162\\/12.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038375610\\/%E6%A0%B7%E5%BC%8F%E5%85%AD%20copy%202%403x.png\",\"left\":42,\"right\":42,\"top\":36,\"bottom\":35,\"stretchableX\":[{\"start\":90,\"stop\":110}],\"stretchableY\":[{\"start\":45,\"stop\":95}],\"width\":369,\"imageType\":3},\"type\":3},{\"id\":\"10\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328911294\\/13.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"8B82F2\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038418173\\/%E6%A0%B7%E5%BC%8F%E4%B8%83%20copy%403x.png\",\"left\":84,\"right\":86,\"top\":64,\"bottom\":73,\"stretchableX\":[{\"start\":76,\"stop\":80}],\"stretchableY\":[{\"start\":85,\"stop\":128}],\"width\":330,\"imageType\":3},\"type\":3},{\"id\":\"3\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328921311\\/14.png\",\"text_type\":\"2\",\"text_infos\":[{\"color\":\"FFBBD4\",\"alpha\":\"1\"},{\"color\":\"5FBDFF\",\"alpha\":\"1\"}],\"stroke_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\",\"width\":\"4\"},{\"color\":\"D53D70\",\"alpha\":\"1\",\"width\":\"2\"}],\"type\":4},{\"id\":\"11\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328932445\\/15.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"000000\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038574480\\/%E6%A0%B7%E5%BC%8F%E5%85%AB%20copy%202%403x.png\",\"left\":84,\"right\":86,\"top\":108,\"bottom\":72,\"stretchableX\":[{\"start\":170,\"stop\":185}],\"stretchableY\":[{\"start\":125,\"stop\":145}],\"width\":300,\"imageType\":3},\"type\":3},{\"id\":\"21\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328943567\\/16.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FF4D86\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328646623\\/%E8%A1%A5%E5%85%85%E5%88%87%E5%9B%BE%403x.png\",\"left\":44,\"right\":12,\"top\":167,\"bottom\":52,\"stretchableX\":[{\"start\":176,\"stop\":178}],\"stretchableY\":[{\"start\":160,\"stop\":200}],\"width\":300,\"imageType\":3},\"type\":3},{\"id\":\"12\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328955001\\/17.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FF739F\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038680352\\/%E6%A0%B7%E5%BC%8F%E4%B9%9D%20copy%202%403x.png\",\"left\":47,\"right\":60,\"top\":33,\"bottom\":75,\"stretchableX\":[{\"start\":60,\"stop\":230}],\"stretchableY\":[{\"start\":62,\"stop\":124}],\"width\":378,\"imageType\":3},\"type\":3},{\"id\":\"13\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328971847\\/18.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038716716\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%20copy%403x.png\",\"left\":25,\"right\":46,\"top\":27,\"bottom\":52,\"stretchableX\":[{\"start\":90,\"stop\":120}],\"stretchableY\":[{\"start\":72,\"stop\":80}],\"width\":336,\"imageType\":3},\"type\":3},{\"id\":\"14\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328981395\\/19.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599038844265\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%E4%B8%80%20copy%202%403x.png\",\"left\":38,\"right\":30,\"top\":67,\"bottom\":24,\"stretchableX\":[{\"start\":192,\"stop\":279}],\"stretchableY\":[{\"start\":76,\"stop\":159}],\"width\":333,\"imageType\":3},\"type\":3},{\"id\":\"15\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600328992077\\/20.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFCDCD\",\"alpha\":\"1\"}],\"shadow_infos\":[{\"color\":\"FF2626\",\"alpha\":\"0.8\",\"width\":\"1\",\"offset_x\":\"0\",\"offset_y\":\"0\",\"blur\":\"9\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599039053238\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%E4%BA%8C%20copy%202%403x.png\",\"left\":58,\"right\":58,\"top\":45,\"bottom\":49,\"stretchableX\":[{\"start\":130,\"stop\":200}],\"stretchableY\":[{\"start\":68,\"stop\":90}],\"width\":399,\"imageType\":3},\"type\":5},{\"id\":\"16\",\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1600329002255\\/21.png\",\"text_type\":\"0\",\"text_infos\":[{\"color\":\"FFFFFF\",\"alpha\":\"1\"}],\"shadow_infos\":[{\"color\":\"EA26FF\",\"alpha\":\"1\",\"width\":\"1\",\"offset_x\":\"0\",\"offset_y\":\"0\",\"blur\":\"1\"}],\"background_infos\":{\"imageUrl\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-9\\/1599039871892\\/%E6%A0%B7%E5%BC%8F%E5%8D%81%E4%B8%89%20copy%202%403x.png\",\"left\":46,\"right\":38,\"top\":65,\"bottom\":89,\"stretchableX\":[{\"start\":67,\"stop\":175}],\"stretchableY\":[{\"start\":55,\"stop\":154}],\"width\":291,\"imageType\":3},\"type\":5}],\"font\":[{\"id\":1,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E9%BB%98%E8%AE%A4%403x.png\",\"download_url\":\"\",\"is_default\":1},{\"id\":2,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E7%B2%97%E9%BB%91%E5%AE%8B%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZCHSJW.TTF\",\"is_default\":0},{\"id\":3,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E6%B8%85%E5%88%BB%E6%9C%AC%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZQKBYSJW.TTF\",\"is_default\":0},{\"id\":4,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E7%88%BD%E8%B6%A3%E4%BD%93%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZShuangQTJW.TTF\",\"is_default\":0},{\"id\":5,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E6%B3%A1%E6%B3%A1%E4%BD%93%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/FZSJ-HLPPJW.TTF\",\"is_default\":0},{\"id\":6,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E5%90%8E%E7%8E%B0%E4%BB%A3%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-4\\/1587628115391\\/WenYue-HouXianDaiTi-W4-75-J.otf\",\"is_default\":0},{\"id\":7,\"icon_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/%E6%96%B0%E9%9D%92%E5%B9%B4%403x.png\",\"download_url\":\"https:\\/\\/pic.rmb.bdstatic.com\\/2020-4\\/1587628115881\\/WenYue-XinQingNianTi-W8-J.otf\",\"is_default\":0}],\"color\":[{\"color\":\"FFFFFF\",\"alpha\":1},{\"color\":\"CCCCCC\",\"alpha\":1},{\"color\":\"999999\",\"alpha\":1},{\"color\":\"666666\",\"alpha\":1},{\"color\":\"333333\",\"alpha\":1},{\"color\":\"000000\",\"alpha\":1},{\"color\":\"FFCDD2\",\"alpha\":1},{\"color\":\"FFA098\",\"alpha\":1},{\"color\":\"FF6E6E\",\"alpha\":1},{\"color\":\"FF5353\",\"alpha\":1},{\"color\":\"FE1818\",\"alpha\":1},{\"color\":\"B71C1C\",\"alpha\":1},{\"color\":\"FFF9C9\",\"alpha\":1},{\"color\":\"FEF589\",\"alpha\":1},{\"color\":\"FEDE00\",\"alpha\":1},{\"color\":\"FA864C\",\"alpha\":1},{\"color\":\"FF7B39\",\"alpha\":1},{\"color\":\"F45100\",\"alpha\":1},{\"color\":\"FED9E8\",\"alpha\":1},{\"color\":\"FFAAC1\",\"alpha\":1},{\"color\":\"FF619D\",\"alpha\":1},{\"color\":\"FE287F\",\"alpha\":1},{\"color\":\"F1166C\",\"alpha\":1},{\"color\":\"941044\",\"alpha\":1},{\"color\":\"C5C4FF\",\"alpha\":1},{\"color\":\"8E80E5\",\"alpha\":1},{\"color\":\"B57DFF\",\"alpha\":1},{\"color\":\"9055FE\",\"alpha\":1},{\"color\":\"6D1FFF\",\"alpha\":1},{\"color\":\"42369A\",\"alpha\":1},{\"color\":\"BEE4FF\",\"alpha\":1},{\"color\":\"91C7FF\",\"alpha\":1},{\"color\":\"469DF3\",\"alpha\":1},{\"color\":\"047BFE\",\"alpha\":1},{\"color\":\"0024FF\",\"alpha\":1},{\"color\":\"1D4AA1\",\"alpha\":1},{\"color\":\"D4F1E9\",\"alpha\":1},{\"color\":\"B9F4CA\",\"alpha\":1},{\"color\":\"69F0AE\",\"alpha\":1},{\"color\":\"00E676\",\"alpha\":1},{\"color\":\"00FF54\",\"alpha\":1},{\"color\":\"18893E\",\"alpha\":1}]}"));
            this.q = parse;
            if (!ListUtils.isEmpty(parse.mCoverStyleList)) {
                for (TextWordsEntity.TextStyleEntity textStyleEntity : this.q.mCoverStyleList) {
                    if (textStyleEntity != null && textStyleEntity.mBackgroudInfoEntity != null && (CreateFileIfNotFound = FileHelper.CreateFileIfNotFound(".cover_style")) != null) {
                        textStyleEntity.mBackgroudInfoEntity.mLocalParentFile = CreateFileIfNotFound.getAbsolutePath();
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f23602j = tbMultiMediaData.videoRatio;
        this.t = new c.a.r0.q0.a.c(z);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23598f == null) {
            return;
        }
        int j2 = t.j(R.dimen.tbds32);
        if (this.f23600h.getWidth() > this.f23600h.getHeight()) {
            j2 = t.j(R.dimen.tbds28);
        }
        c.a.r0.x3.e.d().j((int) (j2 * 1.0f));
        h hVar = new h(this.f23597e.getPageActivity(), this.f23598f);
        this.n = hVar;
        hVar.h("cover_sticker");
        TbGLMediaPreviewView tbGLMediaPreviewView = this.f23600h;
        if (tbGLMediaPreviewView != null) {
            this.n.i(tbGLMediaPreviewView.getWidth(), this.f23600h.getHeight());
        }
        TextWordsEntity textWordsEntity = this.q;
        if (textWordsEntity != null) {
            if (!ListUtils.isEmpty(textWordsEntity.mCoverFontList)) {
                this.n.f(this.q.mCoverFontList.get(0));
            }
            if (ListUtils.isEmpty(this.q.mCoverStyleList)) {
                return;
            }
            this.n.g(this.q.mCoverStyleList.get(0));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23600h.post(new c(this));
            this.f23601i.setPreViewPickCoverViewListener(this);
            this.f23601i.setOnTextWordsEditListener(this);
            this.f23601i.setCoverEntity(this.q);
            this.f23601i.setLastPercent(0.0f);
            this.f23601i.updateSmartCover(0.0f);
            updateVideoCoverPercent(0.0f);
            this.f23601i.notifyCoverData();
            this.f23601i.setMultiMediaData(this.l);
            this.f23598f.seek(0L);
        }
    }

    public final void C(Buffer buffer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, buffer, i2, i3) == null) {
            b.a aVar = new b.a();
            aVar.t(i2);
            aVar.o(i3);
            aVar.p(true);
            aVar.n(buffer);
            aVar.r(this.f23602j);
            VlogEditManager vlogEditManager = this.f23598f;
            aVar.q(vlogEditManager == null ? null : vlogEditManager.getMultiMediaData(vlogEditManager.getCurrentIndex()));
            aVar.s("manual");
            c.a.r0.q0.a.g.b m = aVar.m();
            this.t.e(this);
            this.t.d(m());
            this.t.b(m, "manual");
        }
    }

    @Override // c.a.r0.q0.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d();
        }
    }

    @Override // c.a.r0.q0.a.a
    public void b(c.a.r0.q0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.u = bVar;
        }
    }

    @Override // c.a.r0.q0.a.a
    public void c(VlogEditManager vlogEditManager, MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, vlogEditManager, multiMediaDataSourceViewAdapter) == null) {
            this.f23598f = vlogEditManager;
            vlogEditManager.setStickerMinScale(0.5f);
            this.f23598f.setStickerMaxScale(5.0f);
            this.f23599g = multiMediaDataSourceViewAdapter;
            multiMediaDataSourceViewAdapter.setMultiMediaDataTextureListener(new a(this));
            this.r = new ArrayList<>();
            ArrayList<IMediaRenderer> arrayList = new ArrayList<>();
            this.s = arrayList;
            this.f23599g.buildProcessorsAndRenderers(this.r, arrayList, true);
            this.f23600h.setEffectProcessor(this.r);
            this.f23600h.setMediaRenderers(this.s);
            this.f23599g.setOnChangeStickerListener(this);
            this.f23599g.setOnChangeCoverStickerListener(this);
            z();
        }
    }

    @Override // c.a.r0.q0.a.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t.c(true);
            VlogEditManager vlogEditManager = this.f23598f;
            if (vlogEditManager != null) {
                vlogEditManager.cancelStickerSelected();
            }
            x();
            this.f23600h.queueEvent(new RunnableC1099d(this));
        }
    }

    @Override // c.a.r0.c4.l.d.a
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView.e
    public void f(TextWordsEntity.TextStyleEntity textStyleEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textStyleEntity) == null) {
            this.f23598f.setUpEditLayer("cover_sticker");
            if (textStyleEntity == null) {
                return;
            }
            if (this.o == null) {
                MultiMediaData multiMediaData = new MultiMediaData();
                this.o = multiMediaData;
                multiMediaData.setExt("text", t.l(R.string.ugc_capture_text_words_hint));
                this.m.add(this.o);
                this.n.e(-1);
            } else {
                this.n.e(0);
            }
            this.n.a(116, null, this.o, textStyleEntity, null);
        }
    }

    @Override // c.a.r0.q0.a.a
    public void g(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f2) == null) {
            this.k = f2;
            this.f23601i.updateSmartCover(f2);
        }
    }

    @Override // c.a.r0.q0.a.a
    @Nullable
    public List<MultiMediaData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v : (List) invokeV.objValue;
    }

    @Override // c.a.r0.c4.l.d.a
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n.e(0);
            this.n.a(108, str, this.o, null, null);
        }
    }

    @Override // c.a.r0.q0.a.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.p != null) {
                this.f23598f.deleteMultiMediaData(0);
                this.p = null;
            }
            this.f23598f.reset();
            g(this.k);
        }
    }

    @Override // c.a.r0.q0.a.a
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || this.f23598f == null) {
            return;
        }
        this.f23601i.makeCoverStable();
        if (this.p != null) {
            this.f23598f.deleteMultiMediaData(0);
        }
        MultiMediaData multiMediaData = new MultiMediaData();
        this.p = multiMediaData;
        multiMediaData.path = str;
        multiMediaData.type = 0;
        multiMediaData.start = 0L;
        multiMediaData.end = 3000L;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.p);
        this.f23598f.needDrawEffect(false);
        this.f23598f.addMultiMediaData(0, arrayList);
        this.f23598f.reset();
        this.f23601i.updateVideoCover(BitmapFactory.decodeFile(str));
        this.f23598f.seek(0L);
    }

    @Override // c.a.r0.c4.l.d.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f23601i.hideToolView();
        }
    }

    @Override // c.a.r0.q0.a.a
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.p != null : invokeV.booleanValue;
    }

    @Override // c.a.r0.q0.a.a
    public float n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.k : invokeV.floatValue;
    }

    @Override // c.a.r0.q0.a.a
    public void o(@Nullable List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MultiMediaData multiMediaData : list) {
            arrayList.add((MultiMediaData) multiMediaData.clone());
        }
        this.o = (MultiMediaData) arrayList.get(arrayList.size() - 1);
        this.m.addAll(arrayList);
        h hVar = this.n;
        if (hVar != null) {
            hVar.c(arrayList);
        } else {
            this.f23600h.post(new b(this, arrayList));
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onAutoAdjust(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onChangeSticker(int i2, MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, multiMediaData, str) == null) {
            this.o = multiMediaData;
            this.f23601i.hideToolView();
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onClickSticker(MultiMediaData multiMediaData, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048596, this, multiMediaData, str, z) == null) {
            this.f23601i.showToolView(multiMediaData.getExt("text"));
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onClickStickerOutside(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.o = null;
            this.f23601i.hideToolView();
        }
    }

    @Override // c.a.r0.q0.a.b
    public void onCoverPathCallBack(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            List<MultiMediaData> list = this.v;
            if (list == null) {
                this.v = new ArrayList();
            } else {
                list.clear();
            }
            this.v.addAll(this.m);
            this.o = null;
            w();
            this.f23598f.setUpEditLayer("");
            c.a.r0.q0.a.b bVar = this.u;
            if (bVar != null) {
                bVar.onCoverPathCallBack(str);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onDeleteSticker(MultiMediaData multiMediaData, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{multiMediaData, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            MultiMediaData multiMediaData2 = this.o;
            if (multiMediaData2 != null) {
                multiMediaData2.setExt("text", t.l(R.string.ugc_capture_text_words_hint));
            }
            this.o = null;
            this.f23601i.hideToolView();
        }
    }

    @Override // c.a.r0.q0.a.a
    public void onDestroy() {
        PreViewPickCoverView preViewPickCoverView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (preViewPickCoverView = this.f23601i) == null) {
            return;
        }
        preViewPickCoverView.release();
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onEditSticker(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, multiMediaData, str) == null) {
            this.o = multiMediaData;
            this.f23601i.showToolView(multiMediaData.getExt("text"));
        }
    }

    @Override // com.baidu.ugc.editvideo.sticker.OnChangeStickerListener
    public void onStickerDataChanged(String str, MultiMediaData multiMediaData, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, str, multiMediaData, str2) == null) {
            this.o = multiMediaData;
        }
    }

    @Override // c.a.r0.q0.a.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.o = null;
            w();
            this.f23598f.setUpEditLayer("");
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView.e
    public void updateVideoCover(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j2) == null) {
            VlogEditManager vlogEditManager = this.f23598f;
            if (vlogEditManager != null) {
                vlogEditManager.seek(j2);
            }
            this.f23600h.queueEvent(new e(this));
        }
    }

    @Override // com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView.e
    public void updateVideoCoverPercent(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
            this.k = f2;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            Iterator<MultiMediaData> it = this.m.iterator();
            while (it.hasNext()) {
                y(it.next());
                it.remove();
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Iterator<MultiMediaData> it = this.m.iterator();
            while (it.hasNext()) {
                MultiMediaData next = it.next();
                if (this.n.d(next)) {
                    y(next);
                    it.remove();
                }
            }
        }
    }

    public final void y(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, multiMediaData) == null) {
            VlogEditManager vlogEditManager = this.f23598f;
            if (vlogEditManager != null) {
                vlogEditManager.deleteCoverStickerData(multiMediaData);
            }
            h hVar = this.n;
            if (hVar != null) {
                hVar.b(multiMediaData);
            }
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            B();
            return true;
        }
        return invokeV.booleanValue;
    }
}
