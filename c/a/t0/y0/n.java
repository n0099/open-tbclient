package c.a.t0.y0;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicInteger a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f26517b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f26518c;

        public a(n nVar, AtomicInteger atomicInteger, List list, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, atomicInteger, list, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicInteger;
            this.f26517b = list;
            this.f26518c = cVar;
        }

        @Override // c.a.t0.y0.n.d
        public void a(ImageUploadResult imageUploadResult) {
            ImageUploadResult.picInfo picinfo;
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageUploadResult) == null) {
                this.a.decrementAndGet();
                if (imageUploadResult != null && (picinfo = imageUploadResult.picInfo) != null && (picDetailedInfo = picinfo.bigPic) != null && !TextUtils.isEmpty(picDetailedInfo.picUrl)) {
                    this.f26517b.add(imageUploadResult.picInfo.bigPic.picUrl);
                }
                if (this.a.get() == 0) {
                    if (!ListUtils.isEmpty(this.f26517b)) {
                        this.f26518c.c(this.f26517b);
                    } else {
                        this.f26518c.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f26519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f26520f;

        public b(n nVar, ImageFileInfo imageFileInfo, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, imageFileInfo, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26519e = imageFileInfo;
            this.f26520f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String filePath = this.f26519e.getFilePath();
                c.a.s0.d0.f fVar = new c.a.s0.d0.f("from_user_collect");
                if (this.f26519e.isGif()) {
                    this.f26520f.a(fVar.m(filePath, true, false));
                    return;
                }
                Bitmap b2 = c.a.t0.n2.g.b.b(this.f26519e);
                if (b2 == null) {
                    this.f26520f.a(null);
                    return;
                }
                String saveBitmapByAbsolutelyPath = FileHelper.saveBitmapByAbsolutelyPath(TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath(), "face_" + Math.abs(filePath.hashCode()), b2, 60);
                b2.recycle();
                if (TextUtils.isEmpty(saveBitmapByAbsolutelyPath)) {
                    this.f26520f.a(null);
                    return;
                }
                ImageUploadResult m = fVar.m(saveBitmapByAbsolutelyPath, false, false);
                FileHelper.deleteFile(new File(saveBitmapByAbsolutelyPath));
                this.f26520f.a(m);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void c(List<String> list);

        void d();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(ImageUploadResult imageUploadResult);
    }

    public n() {
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

    public void a(ArrayList<ImageFileInfo> arrayList, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, cVar) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(arrayList.size());
        ArrayList arrayList2 = new ArrayList();
        Iterator<ImageFileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            b(it.next(), new a(this, atomicInteger, arrayList2, cVar));
        }
    }

    public final void b(ImageFileInfo imageFileInfo, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, dVar) == null) {
            c.a.t0.n2.a.b().a(new b(this, imageFileInfo, dVar));
        }
    }
}
