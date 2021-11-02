package b.a.r0.f2.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.s0.t;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.newfaceshop.facemake.UploadFaceGroupModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f16453e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f16454a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<b.a.q0.d0.f> f16455b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16456c;

    /* renamed from: d  reason: collision with root package name */
    public FaceGroupDraft f16457d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<FaceData> f16458e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f16459f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Integer> f16460g;

        /* renamed from: h  reason: collision with root package name */
        public List<FaceData> f16461h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f16462i;
        public final /* synthetic */ l j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;
        public final /* synthetic */ e m;

        /* renamed from: b.a.r0.f2.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0844a implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.f2.g.a f16463a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FaceData f16464b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f16465c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f16466d;

            public C0844a(a aVar, b.a.r0.f2.g.a aVar2, FaceData faceData, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2, faceData, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16466d = aVar;
                this.f16463a = aVar2;
                this.f16464b = faceData;
                this.f16465c = atomicInteger;
            }

            @Override // b.a.r0.f2.g.e.m
            public void a(ImageUploadResult imageUploadResult) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, imageUploadResult) == null) && this.f16463a.a()) {
                    if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                        this.f16464b.pid = String.valueOf(imageUploadResult.picId);
                        FaceData faceData = this.f16464b;
                        ImageUploadResult.PicDetailedInfo picDetailedInfo = imageUploadResult.picInfo.bigPic;
                        faceData.width = picDetailedInfo.width;
                        faceData.height = picDetailedInfo.height;
                        this.f16466d.f16458e.add(faceData);
                        if (this.f16465c.decrementAndGet() == 0) {
                            this.f16466d.b();
                        }
                    } else if (this.f16463a.a()) {
                        this.f16463a.setResult(false);
                        a aVar = this.f16466d;
                        aVar.m.t(aVar.j, "failed to upload image");
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f16467e;

            /* renamed from: b.a.r0.f2.g.e$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0845a implements GetEmotionInfosModel.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f16468a;

                public C0845a(b bVar) {
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
                    this.f16468a = bVar;
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onFail(int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                        a aVar = this.f16468a.f16467e;
                        aVar.m.t(aVar.j, "get pid fail");
                    }
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onSuccess(List<b.a.q0.d0.c> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        for (b.a.q0.d0.c cVar : list) {
                            if (cVar != null) {
                                FaceData faceData = new FaceData();
                                faceData.type = 2;
                                faceData.index = this.f16468a.f16467e.f16460g.get(cVar.f12031g).intValue();
                                faceData.pid = cVar.f12025a;
                                faceData.width = cVar.f12026b;
                                faceData.height = cVar.f12027c;
                                EmotionImageData emotionImageData = new EmotionImageData();
                                emotionImageData.setPicId(cVar.f12025a);
                                emotionImageData.setThumbUrl(cVar.f12029e);
                                emotionImageData.setPicUrl(cVar.f12028d);
                                emotionImageData.setWidth(cVar.f12026b);
                                emotionImageData.setHeight(cVar.f12027c);
                                faceData.emotionImageData = emotionImageData;
                                this.f16468a.f16467e.f16458e.add(faceData);
                            }
                        }
                        UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                        a aVar = this.f16468a.f16467e;
                        uploadFaceGroupModel.y(aVar.k, aVar.f16458e, aVar.j, aVar.l);
                    }
                }
            }

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16467e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f16467e.f16459f.size() > 0) {
                        new GetEmotionInfosModel().y(this.f16467e.f16459f, new C0845a(this));
                        return;
                    }
                    UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                    a aVar = this.f16467e;
                    uploadFaceGroupModel.y(aVar.k, aVar.f16458e, aVar.j, aVar.l);
                }
            }
        }

        public a(e eVar, List list, l lVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, list, lVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = eVar;
            this.f16462i = list;
            this.j = lVar;
            this.k = str;
            this.l = i2;
            this.f16458e = new CopyOnWriteArrayList();
            this.f16459f = new ArrayList();
            this.f16460g = new HashMap();
            this.f16461h = new CopyOnWriteArrayList();
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new Handler(Looper.getMainLooper()).post(new b(this));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (int i2 = 0; i2 < this.f16462i.size(); i2++) {
                    FaceData faceData = (FaceData) this.f16462i.get(i2);
                    faceData.index = i2;
                    int i3 = faceData.type;
                    if (i3 == 2) {
                        EmotionImageData emotionImageData2 = faceData.emotionImageData;
                        if (emotionImageData2 != null) {
                            if (!TextUtils.isEmpty(emotionImageData2.getPicId())) {
                                faceData.pid = emotionImageData2.getPicId();
                                faceData.width = emotionImageData2.getWidth();
                                faceData.height = emotionImageData2.getHeight();
                                this.f16458e.add(faceData);
                            } else {
                                this.f16459f.add(faceData.emotionImageData.getPicUrl());
                                this.f16460g.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                            }
                        }
                    } else if (i3 == 3) {
                        this.f16461h.add(faceData);
                    } else if (i3 == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                        faceData.pid = emotionImageData.getPicId();
                        faceData.width = emotionImageData.getWidth();
                        faceData.height = emotionImageData.getHeight();
                        this.f16458e.add(faceData);
                    }
                }
                if (this.f16461h.size() > 0) {
                    AtomicInteger atomicInteger = new AtomicInteger(this.f16461h.size());
                    b.a.r0.f2.g.a aVar = new b.a.r0.f2.g.a(Boolean.TRUE);
                    for (int i4 = 0; i4 < Math.min(this.f16461h.size(), 4); i4++) {
                        this.m.f16455b.offer(new b.a.q0.d0.f("face group"));
                    }
                    for (int i5 = 0; i5 < this.f16461h.size() && aVar.a(); i5++) {
                        FaceData faceData2 = this.f16461h.get(i5);
                        this.m.B(faceData2.imageFileInfo, new C0844a(this, aVar, faceData2, atomicInteger));
                    }
                    return;
                }
                b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f16469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f16470f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f16471g;

        public b(e eVar, ImageFileInfo imageFileInfo, m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, imageFileInfo, mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16471g = eVar;
            this.f16469e = imageFileInfo;
            this.f16470f = mVar;
        }

        public final void a(m mVar, ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, mVar, imageUploadResult) == null) || mVar == null) {
                return;
            }
            mVar.a(imageUploadResult);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    String filePath = this.f16469e.getFilePath();
                    if (this.f16469e.isGif()) {
                        b.a.q0.d0.f fVar = (b.a.q0.d0.f) this.f16471g.f16455b.poll(10L, TimeUnit.SECONDS);
                        if (fVar != null) {
                            a(this.f16470f, fVar.m(filePath, true, false));
                            this.f16471g.v(fVar);
                            return;
                        }
                        a(this.f16470f, null);
                        return;
                    }
                    Bitmap b2 = b.a.r0.f2.g.b.b(this.f16469e);
                    if (b2 == null) {
                        this.f16470f.a(null);
                        return;
                    }
                    String y = e.y("face_" + Math.abs(filePath.hashCode()), b2, 60);
                    b2.recycle();
                    if (!TextUtils.isEmpty(y)) {
                        b.a.q0.d0.f fVar2 = (b.a.q0.d0.f) this.f16471g.f16455b.poll(10L, TimeUnit.SECONDS);
                        if (fVar2 != null) {
                            ImageUploadResult m = fVar2.m(y, false, false);
                            FileHelper.deleteFile(new File(y));
                            a(this.f16470f, m);
                            this.f16471g.v(fVar2);
                            return;
                        }
                        a(this.f16470f, null);
                        return;
                    }
                    a(this.f16470f, null);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.f2.g.a f16472a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f16473b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f16474c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.f2.f.a f16475d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f16477f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f16478g;

        public c(e eVar, b.a.r0.f2.g.a aVar, List list, List list2, b.a.r0.f2.f.a aVar2, String str, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar, list, list2, aVar2, str, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16478g = eVar;
            this.f16472a = aVar;
            this.f16473b = list;
            this.f16474c = list2;
            this.f16475d = aVar2;
            this.f16476e = str;
            this.f16477f = kVar;
        }

        @Override // b.a.r0.f2.g.e.j
        public void a(b.a.r0.f2.f.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && this.f16472a.a()) {
                this.f16473b.add(bVar);
                if (this.f16473b.size() == this.f16474c.size()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f16473b);
                    Collections.sort(arrayList);
                    this.f16475d.f16431e = arrayList;
                    if (this.f16478g.j(this.f16476e + ((b.a.r0.f2.f.b) arrayList.get(0)).f16435h, this.f16476e)) {
                        this.f16478g.o(this.f16475d, this.f16477f);
                    } else {
                        onFail("face group:fail to create panel");
                    }
                }
            }
        }

        @Override // b.a.r0.f2.g.e.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f16472a.a()) {
                this.f16472a.setResult(false);
                this.f16478g.s(this.f16477f, false);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f16479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16480f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f16481g;

        public d(e eVar, FaceData faceData, String str, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, faceData, str, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16479e = faceData;
            this.f16480f = str;
            this.f16481g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap resizeBitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageFileInfo imageFileInfo = this.f16479e.imageFileInfo;
                String filePath = imageFileInfo.getFilePath();
                String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
                if (TextUtils.isEmpty(substring)) {
                    substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                }
                String str = "t_" + substring;
                if (FileHelper.copyFileByAbsolutelyPath(filePath, this.f16480f + substring)) {
                    Bitmap b2 = b.a.r0.f2.g.b.b(imageFileInfo);
                    if (b2 == null) {
                        this.f16481g.onFail("face group: fail to get origin bitmap when install album emotion");
                        return;
                    }
                    if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(b2, 240, 240, false)) != null) {
                        b.a.r0.f2.b.e(this.f16480f, substring, resizeBitmap, 100);
                        if (resizeBitmap != b2) {
                            resizeBitmap.recycle();
                        }
                    }
                    Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(b2, 150, 150, false);
                    if (resizeBitmap2 == null) {
                        this.f16481g.onFail("face group: fail to create small file when install album emotion");
                        return;
                    }
                    b.a.r0.f2.b.e(this.f16480f, str, resizeBitmap2, 100);
                    if (resizeBitmap2 != b2) {
                        resizeBitmap2.recycle();
                    }
                    b2.recycle();
                    b.a.r0.f2.f.b bVar = new b.a.r0.f2.f.b();
                    FaceData faceData = this.f16479e;
                    bVar.f16432e = faceData.index;
                    bVar.f16433f = faceData.pid;
                    bVar.f16434g = substring;
                    bVar.f16435h = str;
                    bVar.j = faceData.width;
                    bVar.f16436i = faceData.height;
                    this.f16481g.a(bVar);
                    return;
                }
                this.f16481g.onFail("face group: fail to copy file when install album emotion");
            }
        }
    }

    /* renamed from: b.a.r0.f2.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0846e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f16482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f16484g;

        public RunnableC0846e(e eVar, FaceData faceData, String str, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, faceData, str, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16482e = faceData;
            this.f16483f = str;
            this.f16484g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.f16482e.emotionImageData;
                String str = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
                String str2 = "t_" + str;
                String o = t.o(this.f16482e.pid, true);
                String o2 = t.o(this.f16482e.pid, false);
                if (!FileHelper.copyFileByAbsolutelyPath(o, this.f16483f + str)) {
                    this.f16484g.onFail("face group: fail to copy big file when install collect emotion");
                    return;
                }
                if (!FileHelper.copyFileByAbsolutelyPath(o2, this.f16483f + str2)) {
                    this.f16484g.onFail("face group: fail to copy small file when install collect emotion");
                    return;
                }
                b.a.r0.f2.f.b bVar = new b.a.r0.f2.f.b();
                FaceData faceData = this.f16482e;
                bVar.f16432e = faceData.index;
                bVar.f16433f = faceData.pid;
                bVar.f16434g = str;
                bVar.f16435h = str2;
                bVar.j = faceData.width;
                bVar.f16436i = faceData.height;
                this.f16484g.a(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f16485e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f16486f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16487g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f16488h;

        public f(e eVar, FaceData faceData, j jVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, faceData, jVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16488h = eVar;
            this.f16485e = faceData;
            this.f16486f = jVar;
            this.f16487g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.f16485e.emotionImageData;
                String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
                String str = "t_" + substring;
                WebClient webClient = new WebClient();
                byte[] downloadImageBytes = webClient.downloadImageBytes(emotionImageData.getPicUrl(), false);
                if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                    this.f16488h.x(this.f16487g, substring, downloadImageBytes);
                    byte[] downloadImageBytes2 = webClient.downloadImageBytes(emotionImageData.getThumbUrl(), false);
                    if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                        this.f16488h.x(this.f16487g, str, downloadImageBytes2);
                        b.a.r0.f2.f.b bVar = new b.a.r0.f2.f.b();
                        FaceData faceData = this.f16485e;
                        bVar.f16432e = faceData.index;
                        bVar.f16433f = faceData.pid;
                        bVar.f16434g = substring;
                        bVar.f16435h = str;
                        bVar.j = faceData.width;
                        bVar.f16436i = faceData.height;
                        this.f16486f.a(bVar);
                        return;
                    }
                    this.f16486f.onFail("face group: fail to download small file when install search emotion");
                    return;
                }
                this.f16486f.onFail("face group: fail to download big file when install search emotion");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f16489e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f16490f;

        public g(e eVar, k kVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, kVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16489e = kVar;
            this.f16490f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k kVar = this.f16489e;
                if (kVar != null) {
                    if (this.f16490f) {
                        kVar.onSuccess();
                    } else {
                        kVar.onFail();
                    }
                }
                if (this.f16490f) {
                    b.a.r0.f2.d.m().w();
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("upload_result", new Boolean(true));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f16491e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16492f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f16493g;

        public h(e eVar, l lVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, lVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16493g = eVar;
            this.f16491e = lVar;
            this.f16492f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l lVar = this.f16491e;
                if (lVar != null) {
                    lVar.onFail(this.f16492f);
                }
                if (this.f16492f != null) {
                    BdLog.e("face group:" + this.f16492f);
                }
                this.f16493g.u(false, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f16494e;

        public i(e eVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16494e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, this.f16494e));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(b.a.r0.f2.f.b bVar);

        void onFail(String str);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes4.dex */
    public interface l {
        void a(String str, List<FaceData> list);

        void onFail(String str);
    }

    /* loaded from: classes4.dex */
    public interface m {
        void a(ImageUploadResult imageUploadResult);
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16454a = new Handler(Looper.getMainLooper());
        this.f16455b = new LinkedBlockingQueue(4);
    }

    public static e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f16453e == null) {
                synchronized (e.class) {
                    if (f16453e == null) {
                        f16453e = new e();
                    }
                }
            }
            return f16453e;
        }
        return (e) invokeV.objValue;
    }

    public static String y(String str, Bitmap bitmap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, str, bitmap, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
            if (cacheDir.exists() && !cacheDir.isDirectory()) {
                cacheDir.delete();
            }
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            File file = new File(cacheDir, str);
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getAbsolutePath();
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, b.a.e.e.p.k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
                return null;
            }
        }
        return (String) invokeLLI.objValue;
    }

    public void A(String str, List<FaceData> list, l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, str, list, lVar, i2) == null) {
            this.f16456c = true;
            w(str, list, i2);
            if (TextUtils.isEmpty(str)) {
                t(lVar, "name empty");
            } else if (list == null) {
                t(lVar, "list empty");
            } else {
                z(list);
                b.a.r0.f2.a.b().a(new a(this, list, lVar, str, i2));
            }
        }
    }

    public final void B(ImageFileInfo imageFileInfo, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, mVar) == null) {
            b.a.r0.f2.a.b().a(new b(this, imageFileInfo, mVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16457d = null;
            b.a.r0.f2.g.c.a();
        }
    }

    public final boolean j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            Bitmap a2 = b.a.r0.f2.g.b.a(str);
            if (a2 == null) {
                BdLog.e("cover bitmap null");
                return false;
            } else if (TextUtils.isEmpty(b.a.r0.f2.b.e(str2, "panel.png", a2, 60))) {
                BdLog.e("fail to save Panel");
                return false;
            } else if (TextUtils.isEmpty(b.a.r0.f2.b.e(str2, "panel_momo.png", a2, 60))) {
                BdLog.e("fail to save PanelMomo");
                return false;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public FaceGroupDraft k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f16457d == null) {
                this.f16457d = b.a.r0.f2.g.c.b();
            }
            return this.f16457d;
        }
        return (FaceGroupDraft) invokeV.objValue;
    }

    public final void m(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, faceData, str, jVar) == null) {
            b.a.r0.f2.a.b().a(new d(this, faceData, str, jVar));
        }
    }

    public final void n(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, faceData, str, jVar) == null) {
            b.a.r0.f2.a.b().a(new RunnableC0846e(this, faceData, str, jVar));
        }
    }

    public final void o(b.a.r0.f2.f.a aVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, aVar, kVar) == null) {
            int f2 = b.a.r0.s0.a.c().f(aVar);
            if (f2 == 0) {
                BdLog.e("no valid emotion");
                s(kVar, false);
                return;
            }
            EmotionGroupData emotionGroupData = new EmotionGroupData();
            emotionGroupData.setGroupId(aVar.f16427a);
            emotionGroupData.setEmotionsCount(f2);
            emotionGroupData.setHeight(aVar.f16431e.get(0).f16436i);
            emotionGroupData.setWidth(aVar.f16431e.get(0).j);
            emotionGroupData.setDownloadTime(System.currentTimeMillis());
            emotionGroupData.setGroupName(aVar.f16428b);
            emotionGroupData.setStatus(1);
            b.a.r0.s0.g.k().e(emotionGroupData);
            b.a.r0.s0.g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
            s(kVar, true);
        }
    }

    public void p(String str, List<FaceData> list, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, kVar) == null) {
            String str2 = b.a.r0.f2.c.f16398c + str + "/";
            new File(str2).mkdirs();
            b.a.r0.f2.f.a aVar = new b.a.r0.f2.f.a();
            TbadkCoreApplication.getCurrentAccount();
            TbadkCoreApplication.getCurrentAccountName();
            aVar.f16427a = str;
            String.valueOf(System.currentTimeMillis());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            b.a.r0.f2.g.a aVar2 = new b.a.r0.f2.g.a(Boolean.TRUE);
            c cVar = new c(this, aVar2, copyOnWriteArrayList, list, aVar, str2, kVar);
            for (FaceData faceData : list) {
                if (!aVar2.a()) {
                    return;
                }
                int i2 = faceData.type;
                if (i2 == 3) {
                    m(faceData, str2, cVar);
                } else if (i2 == 1) {
                    n(faceData, str2, cVar);
                } else if (i2 == 2) {
                    q(faceData, str2, cVar);
                } else {
                    cVar.onFail("facegroup:un support type in list");
                    return;
                }
            }
        }
    }

    public final void q(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, faceData, str, jVar) == null) {
            b.a.r0.f2.a.b().a(new f(this, faceData, jVar, str));
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f16456c : invokeV.booleanValue;
    }

    public final void s(k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, kVar, z) == null) {
            this.f16454a.post(new g(this, kVar, z));
        }
    }

    public final void t(l lVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, lVar, str) == null) {
            this.f16454a.post(new h(this, lVar, str));
        }
    }

    public void u(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            if (this.f16456c) {
                this.f16456c = false;
            }
            if (z) {
                i();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("upload_result", new Boolean(false));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("upload_msg", str);
                FaceGroupDraft faceGroupDraft = this.f16457d;
                if (faceGroupDraft != null) {
                    faceGroupDraft.setFailMsg(str);
                }
            }
            b.a.r0.f2.g.c.c(this.f16457d);
            this.f16454a.postDelayed(new i(this, hashMap), 1000L);
        }
    }

    public final void v(b.a.q0.d0.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.f16455b.offer(fVar);
        }
    }

    public void w(String str, List<FaceData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, str, list, i2) == null) {
            FaceGroupDraft faceGroupDraft = new FaceGroupDraft();
            this.f16457d = faceGroupDraft;
            faceGroupDraft.setName(str);
            this.f16457d.setList(list);
            this.f16457d.setForumId(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String x(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048592, this, str, str2, bArr)) != null) {
            return (String) invokeLLL.objValue;
        }
        File file = new File(str + str2);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    fileOutputStream3.write(bArr, 0, bArr.length);
                    fileOutputStream3.flush();
                    fileOutputStream3.close();
                    return file.getPath();
                } catch (IOException e2) {
                    fileOutputStream = fileOutputStream3;
                    e = e2;
                    try {
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                BdLog.e(th.getMessage());
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th3) {
                                BdLog.e(th3.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void z(List<FaceData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (FaceData faceData : list) {
            if (faceData != null) {
                int i5 = faceData.type;
                if (i5 == 1) {
                    i3++;
                } else if (i5 == 2) {
                    i2++;
                } else if (i5 == 3) {
                    i4++;
                }
            }
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
        statisticItem.param("obj_source", 3);
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
        statisticItem2.param("obj_source", 2);
        statisticItem2.param("obj_type", i3);
        TiebaStatic.log(statisticItem2);
        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
        statisticItem3.param("obj_source", 1);
        statisticItem3.param("obj_type", i4);
        TiebaStatic.log(statisticItem3);
    }
}
