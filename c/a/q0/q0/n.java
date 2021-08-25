package c.a.q0.q0;

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
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f23739a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f23740b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f23741c;

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
            this.f23739a = atomicInteger;
            this.f23740b = list;
            this.f23741c = cVar;
        }

        @Override // c.a.q0.q0.n.d
        public void a(ImageUploadResult imageUploadResult) {
            ImageUploadResult.picInfo picinfo;
            ImageUploadResult.PicDetailedInfo picDetailedInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imageUploadResult) == null) {
                this.f23739a.decrementAndGet();
                if (imageUploadResult != null && (picinfo = imageUploadResult.picInfo) != null && (picDetailedInfo = picinfo.bigPic) != null && !TextUtils.isEmpty(picDetailedInfo.picUrl)) {
                    this.f23740b.add(imageUploadResult.picInfo.bigPic.picUrl);
                }
                if (this.f23739a.get() == 0) {
                    if (!ListUtils.isEmpty(this.f23740b)) {
                        this.f23741c.c(this.f23740b);
                    } else {
                        this.f23741c.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageFileInfo f23742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f23743f;

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
            this.f23742e = imageFileInfo;
            this.f23743f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String filePath = this.f23742e.getFilePath();
                c.a.p0.c0.f fVar = new c.a.p0.c0.f("from_user_collect");
                if (this.f23742e.isGif()) {
                    this.f23743f.a(fVar.m(filePath, true, false));
                    return;
                }
                Bitmap b2 = c.a.q0.d2.g.b.b(this.f23742e);
                if (b2 == null) {
                    this.f23743f.a(null);
                    return;
                }
                String saveFile = FileHelper.saveFile(TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath(), "face_" + Math.abs(filePath.hashCode()), b2, 60);
                b2.recycle();
                if (TextUtils.isEmpty(saveFile)) {
                    this.f23743f.a(null);
                    return;
                }
                ImageUploadResult m = fVar.m(saveFile, false, false);
                FileHelper.deleteFile(new File(saveFile));
                this.f23743f.a(m);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void c(List<String> list);

        void d();
    }

    /* loaded from: classes3.dex */
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
            c.a.q0.d2.a.b().a(new b(this, imageFileInfo, dVar));
        }
    }
}
