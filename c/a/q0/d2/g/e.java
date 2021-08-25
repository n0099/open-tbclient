package c.a.q0.d2.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.q0.t;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f16750e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f16751a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<c.a.p0.c0.f> f16752b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16753c;

    /* renamed from: d  reason: collision with root package name */
    public FaceGroupDraft f16754d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<FaceData> f16755e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f16756f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Integer> f16757g;

        /* renamed from: h  reason: collision with root package name */
        public List<FaceData> f16758h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f16759i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ l f16760j;
        public final /* synthetic */ String k;
        public final /* synthetic */ int l;
        public final /* synthetic */ e m;

        /* renamed from: c.a.q0.d2.g.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0809a implements m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.d2.g.a f16761a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ FaceData f16762b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f16763c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f16764d;

            public C0809a(a aVar, c.a.q0.d2.g.a aVar2, FaceData faceData, AtomicInteger atomicInteger) {
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
                this.f16764d = aVar;
                this.f16761a = aVar2;
                this.f16762b = faceData;
                this.f16763c = atomicInteger;
            }

            @Override // c.a.q0.d2.g.e.m
            public void a(ImageUploadResult imageUploadResult) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, imageUploadResult) == null) && this.f16761a.a()) {
                    if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                        this.f16762b.pid = String.valueOf(imageUploadResult.picId);
                        FaceData faceData = this.f16762b;
                        ImageUploadResult.PicDetailedInfo picDetailedInfo = imageUploadResult.picInfo.bigPic;
                        faceData.width = picDetailedInfo.width;
                        faceData.height = picDetailedInfo.height;
                        this.f16764d.f16755e.add(faceData);
                        if (this.f16763c.decrementAndGet() == 0) {
                            this.f16764d.b();
                        }
                    } else if (this.f16761a.a()) {
                        this.f16761a.b(false);
                        a aVar = this.f16764d;
                        aVar.m.t(aVar.f16760j, "failed to upload image");
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f16765e;

            /* renamed from: c.a.q0.d2.g.e$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0810a implements GetEmotionInfosModel.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f16766a;

                public C0810a(b bVar) {
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
                    this.f16766a = bVar;
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onFail(int i2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                        a aVar = this.f16766a.f16765e;
                        aVar.m.t(aVar.f16760j, "get pid fail");
                    }
                }

                @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
                public void onSuccess(List<c.a.p0.c0.c> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        for (c.a.p0.c0.c cVar : list) {
                            if (cVar != null) {
                                FaceData faceData = new FaceData();
                                faceData.type = 2;
                                faceData.index = this.f16766a.f16765e.f16757g.get(cVar.f12980g).intValue();
                                faceData.pid = cVar.f12974a;
                                faceData.width = cVar.f12975b;
                                faceData.height = cVar.f12976c;
                                EmotionImageData emotionImageData = new EmotionImageData();
                                emotionImageData.setPicId(cVar.f12974a);
                                emotionImageData.setThumbUrl(cVar.f12978e);
                                emotionImageData.setPicUrl(cVar.f12977d);
                                emotionImageData.setWidth(cVar.f12975b);
                                emotionImageData.setHeight(cVar.f12976c);
                                faceData.emotionImageData = emotionImageData;
                                this.f16766a.f16765e.f16755e.add(faceData);
                            }
                        }
                        UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                        a aVar = this.f16766a.f16765e;
                        uploadFaceGroupModel.y(aVar.k, aVar.f16755e, aVar.f16760j, aVar.l);
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
                this.f16765e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f16765e.f16756f.size() > 0) {
                        new GetEmotionInfosModel().y(this.f16765e.f16756f, new C0810a(this));
                        return;
                    }
                    UploadFaceGroupModel uploadFaceGroupModel = new UploadFaceGroupModel();
                    a aVar = this.f16765e;
                    uploadFaceGroupModel.y(aVar.k, aVar.f16755e, aVar.f16760j, aVar.l);
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
            this.f16759i = list;
            this.f16760j = lVar;
            this.k = str;
            this.l = i2;
            this.f16755e = new CopyOnWriteArrayList();
            this.f16756f = new ArrayList();
            this.f16757g = new HashMap();
            this.f16758h = new CopyOnWriteArrayList();
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
                for (int i2 = 0; i2 < this.f16759i.size(); i2++) {
                    FaceData faceData = (FaceData) this.f16759i.get(i2);
                    faceData.index = i2;
                    int i3 = faceData.type;
                    if (i3 == 2) {
                        EmotionImageData emotionImageData2 = faceData.emotionImageData;
                        if (emotionImageData2 != null) {
                            if (!TextUtils.isEmpty(emotionImageData2.getPicId())) {
                                faceData.pid = emotionImageData2.getPicId();
                                faceData.width = emotionImageData2.getWidth();
                                faceData.height = emotionImageData2.getHeight();
                                this.f16755e.add(faceData);
                            } else {
                                this.f16756f.add(faceData.emotionImageData.getPicUrl());
                                this.f16757g.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                            }
                        }
                    } else if (i3 == 3) {
                        this.f16758h.add(faceData);
                    } else if (i3 == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                        faceData.pid = emotionImageData.getPicId();
                        faceData.width = emotionImageData.getWidth();
                        faceData.height = emotionImageData.getHeight();
                        this.f16755e.add(faceData);
                    }
                }
                if (this.f16758h.size() > 0) {
                    AtomicInteger atomicInteger = new AtomicInteger(this.f16758h.size());
                    c.a.q0.d2.g.a aVar = new c.a.q0.d2.g.a(Boolean.TRUE);
                    for (int i4 = 0; i4 < Math.min(this.f16758h.size(), 4); i4++) {
                        this.m.f16752b.offer(new c.a.p0.c0.f("face group"));
                    }
                    for (int i5 = 0; i5 < this.f16758h.size() && aVar.a(); i5++) {
                        FaceData faceData2 = this.f16758h.get(i5);
                        this.m.B(faceData2.imageFileInfo, new C0809a(this, aVar, faceData2, atomicInteger));
                    }
                    return;
                }
                b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f16767e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f16768f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f16769g;

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
            this.f16769g = eVar;
            this.f16767e = imageFileInfo;
            this.f16768f = mVar;
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
                    String filePath = this.f16767e.getFilePath();
                    if (this.f16767e.isGif()) {
                        c.a.p0.c0.f fVar = (c.a.p0.c0.f) this.f16769g.f16752b.poll(10L, TimeUnit.SECONDS);
                        if (fVar != null) {
                            a(this.f16768f, fVar.m(filePath, true, false));
                            this.f16769g.v(fVar);
                            return;
                        }
                        a(this.f16768f, null);
                        return;
                    }
                    Bitmap b2 = c.a.q0.d2.g.b.b(this.f16767e);
                    if (b2 == null) {
                        this.f16768f.a(null);
                        return;
                    }
                    String y = e.y("face_" + Math.abs(filePath.hashCode()), b2, 60);
                    b2.recycle();
                    if (!TextUtils.isEmpty(y)) {
                        c.a.p0.c0.f fVar2 = (c.a.p0.c0.f) this.f16769g.f16752b.poll(10L, TimeUnit.SECONDS);
                        if (fVar2 != null) {
                            ImageUploadResult m = fVar2.m(y, false, false);
                            FileHelper.deleteFile(new File(y));
                            a(this.f16768f, m);
                            this.f16769g.v(fVar2);
                            return;
                        }
                        a(this.f16768f, null);
                        return;
                    }
                    a(this.f16768f, null);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.d2.g.a f16770a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f16771b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f16772c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.d2.f.a f16773d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f16774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f16775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f16776g;

        public c(e eVar, c.a.q0.d2.g.a aVar, List list, List list2, c.a.q0.d2.f.a aVar2, String str, k kVar) {
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
            this.f16776g = eVar;
            this.f16770a = aVar;
            this.f16771b = list;
            this.f16772c = list2;
            this.f16773d = aVar2;
            this.f16774e = str;
            this.f16775f = kVar;
        }

        @Override // c.a.q0.d2.g.e.j
        public void a(c.a.q0.d2.f.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && this.f16770a.a()) {
                this.f16771b.add(bVar);
                if (this.f16771b.size() == this.f16772c.size()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f16771b);
                    Collections.sort(arrayList);
                    this.f16773d.f16726e = arrayList;
                    if (this.f16776g.j(this.f16774e + ((c.a.q0.d2.f.b) arrayList.get(0)).f16730h, this.f16774e)) {
                        this.f16776g.o(this.f16773d, this.f16775f);
                    } else {
                        onFail("face group:fail to create panel");
                    }
                }
            }
        }

        @Override // c.a.q0.d2.g.e.j
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f16770a.a()) {
                this.f16770a.b(false);
                this.f16776g.s(this.f16775f, false);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                BdLog.e(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f16777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16778f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f16779g;

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
            this.f16777e = faceData;
            this.f16778f = str;
            this.f16779g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap resizeBitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ImageFileInfo imageFileInfo = this.f16777e.imageFileInfo;
                String filePath = imageFileInfo.getFilePath();
                String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
                if (TextUtils.isEmpty(substring)) {
                    substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                }
                String str = "t_" + substring;
                if (FileHelper.copyFile(filePath, this.f16778f + substring)) {
                    Bitmap b2 = c.a.q0.d2.g.b.b(imageFileInfo);
                    if (b2 == null) {
                        this.f16779g.onFail("face group: fail to get origin bitmap when install album emotion");
                        return;
                    }
                    if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(b2, 240, 240, false)) != null) {
                        c.a.q0.d2.b.e(this.f16778f, substring, resizeBitmap, 100);
                        if (resizeBitmap != b2) {
                            resizeBitmap.recycle();
                        }
                    }
                    Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(b2, 150, 150, false);
                    if (resizeBitmap2 == null) {
                        this.f16779g.onFail("face group: fail to create small file when install album emotion");
                        return;
                    }
                    c.a.q0.d2.b.e(this.f16778f, str, resizeBitmap2, 100);
                    if (resizeBitmap2 != b2) {
                        resizeBitmap2.recycle();
                    }
                    b2.recycle();
                    c.a.q0.d2.f.b bVar = new c.a.q0.d2.f.b();
                    FaceData faceData = this.f16777e;
                    bVar.f16727e = faceData.index;
                    bVar.f16728f = faceData.pid;
                    bVar.f16729g = substring;
                    bVar.f16730h = str;
                    bVar.f16732j = faceData.width;
                    bVar.f16731i = faceData.height;
                    this.f16779g.a(bVar);
                    return;
                }
                this.f16779g.onFail("face group: fail to copy file when install album emotion");
            }
        }
    }

    /* renamed from: c.a.q0.d2.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0811e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f16780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16781f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f16782g;

        public RunnableC0811e(e eVar, FaceData faceData, String str, j jVar) {
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
            this.f16780e = faceData;
            this.f16781f = str;
            this.f16782g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.f16780e.emotionImageData;
                String str = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
                String str2 = "t_" + str;
                String o = t.o(this.f16780e.pid, true);
                String o2 = t.o(this.f16780e.pid, false);
                if (!FileHelper.copyFile(o, this.f16781f + str)) {
                    this.f16782g.onFail("face group: fail to copy big file when install collect emotion");
                    return;
                }
                if (!FileHelper.copyFile(o2, this.f16781f + str2)) {
                    this.f16782g.onFail("face group: fail to copy small file when install collect emotion");
                    return;
                }
                c.a.q0.d2.f.b bVar = new c.a.q0.d2.f.b();
                FaceData faceData = this.f16780e;
                bVar.f16727e = faceData.index;
                bVar.f16728f = faceData.pid;
                bVar.f16729g = str;
                bVar.f16730h = str2;
                bVar.f16732j = faceData.width;
                bVar.f16731i = faceData.height;
                this.f16782g.a(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceData f16783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f16784f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16785g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f16786h;

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
            this.f16786h = eVar;
            this.f16783e = faceData;
            this.f16784f = jVar;
            this.f16785g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EmotionImageData emotionImageData = this.f16783e.emotionImageData;
                String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
                String str = "t_" + substring;
                WebClient webClient = new WebClient();
                byte[] downloadImageBytes = webClient.downloadImageBytes(emotionImageData.getPicUrl(), false);
                if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                    this.f16786h.x(this.f16785g, substring, downloadImageBytes);
                    byte[] downloadImageBytes2 = webClient.downloadImageBytes(emotionImageData.getThumbUrl(), false);
                    if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                        this.f16786h.x(this.f16785g, str, downloadImageBytes2);
                        c.a.q0.d2.f.b bVar = new c.a.q0.d2.f.b();
                        FaceData faceData = this.f16783e;
                        bVar.f16727e = faceData.index;
                        bVar.f16728f = faceData.pid;
                        bVar.f16729g = substring;
                        bVar.f16730h = str;
                        bVar.f16732j = faceData.width;
                        bVar.f16731i = faceData.height;
                        this.f16784f.a(bVar);
                        return;
                    }
                    this.f16784f.onFail("face group: fail to download small file when install search emotion");
                    return;
                }
                this.f16784f.onFail("face group: fail to download big file when install search emotion");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f16787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f16788f;

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
            this.f16787e = kVar;
            this.f16788f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k kVar = this.f16787e;
                if (kVar != null) {
                    if (this.f16788f) {
                        kVar.onSuccess();
                    } else {
                        kVar.onFail();
                    }
                }
                if (this.f16788f) {
                    c.a.q0.d2.d.m().w();
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("upload_result", new Boolean(true));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, hashMap));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f16789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16790f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f16791g;

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
            this.f16791g = eVar;
            this.f16789e = lVar;
            this.f16790f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l lVar = this.f16789e;
                if (lVar != null) {
                    lVar.onFail(this.f16790f);
                }
                if (this.f16790f != null) {
                    BdLog.e("face group:" + this.f16790f);
                }
                this.f16791g.u(false, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f16792e;

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
            this.f16792e = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921040, this.f16792e));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(c.a.q0.d2.f.b bVar);

        void onFail(String str);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(String str, List<FaceData> list);

        void onFail(String str);
    }

    /* loaded from: classes3.dex */
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
        this.f16751a = new Handler(Looper.getMainLooper());
        this.f16752b = new LinkedBlockingQueue(4);
    }

    public static e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f16750e == null) {
                synchronized (e.class) {
                    if (f16750e == null) {
                        f16750e = new e();
                    }
                }
            }
            return f16750e;
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
                TiebaStatic.file(e2, c.a.e.e.p.k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
                return null;
            }
        }
        return (String) invokeLLI.objValue;
    }

    public void A(String str, List<FaceData> list, l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, str, list, lVar, i2) == null) {
            this.f16753c = true;
            w(str, list, i2);
            if (TextUtils.isEmpty(str)) {
                t(lVar, "name empty");
            } else if (list == null) {
                t(lVar, "list empty");
            } else {
                z(list);
                c.a.q0.d2.a.b().a(new a(this, list, lVar, str, i2));
            }
        }
    }

    public final void B(ImageFileInfo imageFileInfo, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, mVar) == null) {
            c.a.q0.d2.a.b().a(new b(this, imageFileInfo, mVar));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16754d = null;
            c.a.q0.d2.g.c.a();
        }
    }

    public final boolean j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            Bitmap a2 = c.a.q0.d2.g.b.a(str);
            if (a2 == null) {
                BdLog.e("cover bitmap null");
                return false;
            } else if (TextUtils.isEmpty(c.a.q0.d2.b.e(str2, "panel.png", a2, 60))) {
                BdLog.e("fail to save Panel");
                return false;
            } else if (TextUtils.isEmpty(c.a.q0.d2.b.e(str2, "panel_momo.png", a2, 60))) {
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
            if (this.f16754d == null) {
                this.f16754d = c.a.q0.d2.g.c.b();
            }
            return this.f16754d;
        }
        return (FaceGroupDraft) invokeV.objValue;
    }

    public final void m(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, faceData, str, jVar) == null) {
            c.a.q0.d2.a.b().a(new d(this, faceData, str, jVar));
        }
    }

    public final void n(FaceData faceData, String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, faceData, str, jVar) == null) {
            c.a.q0.d2.a.b().a(new RunnableC0811e(this, faceData, str, jVar));
        }
    }

    public final void o(c.a.q0.d2.f.a aVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, aVar, kVar) == null) {
            int f2 = c.a.q0.q0.a.c().f(aVar);
            if (f2 == 0) {
                BdLog.e("no valid emotion");
                s(kVar, false);
                return;
            }
            EmotionGroupData emotionGroupData = new EmotionGroupData();
            emotionGroupData.setGroupId(aVar.f16722a);
            emotionGroupData.setEmotionsCount(f2);
            emotionGroupData.setHeight(aVar.f16726e.get(0).f16731i);
            emotionGroupData.setWidth(aVar.f16726e.get(0).f16732j);
            emotionGroupData.setDownloadTime(System.currentTimeMillis());
            emotionGroupData.setGroupName(aVar.f16723b);
            emotionGroupData.setStatus(1);
            c.a.q0.q0.g.k().e(emotionGroupData);
            c.a.q0.q0.g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
            s(kVar, true);
        }
    }

    public void p(String str, List<FaceData> list, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, kVar) == null) {
            String str2 = c.a.q0.d2.c.f16693c + str + "/";
            new File(str2).mkdirs();
            c.a.q0.d2.f.a aVar = new c.a.q0.d2.f.a();
            TbadkCoreApplication.getCurrentAccount();
            TbadkCoreApplication.getCurrentAccountName();
            aVar.f16722a = str;
            String.valueOf(System.currentTimeMillis());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            c.a.q0.d2.g.a aVar2 = new c.a.q0.d2.g.a(Boolean.TRUE);
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
            c.a.q0.d2.a.b().a(new f(this, faceData, jVar, str));
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f16753c : invokeV.booleanValue;
    }

    public final void s(k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, kVar, z) == null) {
            this.f16751a.post(new g(this, kVar, z));
        }
    }

    public final void t(l lVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, lVar, str) == null) {
            this.f16751a.post(new h(this, lVar, str));
        }
    }

    public void u(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, str) == null) {
            if (this.f16753c) {
                this.f16753c = false;
            }
            if (z) {
                i();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("upload_result", new Boolean(false));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("upload_msg", str);
                FaceGroupDraft faceGroupDraft = this.f16754d;
                if (faceGroupDraft != null) {
                    faceGroupDraft.setFailMsg(str);
                }
            }
            c.a.q0.d2.g.c.c(this.f16754d);
            this.f16751a.postDelayed(new i(this, hashMap), 1000L);
        }
    }

    public final void v(c.a.p0.c0.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.f16752b.offer(fVar);
        }
    }

    public void w(String str, List<FaceData> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048591, this, str, list, i2) == null) {
            FaceGroupDraft faceGroupDraft = new FaceGroupDraft();
            this.f16754d = faceGroupDraft;
            faceGroupDraft.setName(str);
            this.f16754d.setList(list);
            this.f16754d.setForumId(i2);
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
