package c.a.p0.c0;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.c0.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<b<T>> f12955a;

    /* renamed from: b  reason: collision with root package name */
    public d f12956b;

    /* renamed from: c  reason: collision with root package name */
    public String f12957c;

    /* renamed from: d  reason: collision with root package name */
    public a<T>.c f12958d;

    /* renamed from: e  reason: collision with root package name */
    public T f12959e;

    /* renamed from: f  reason: collision with root package name */
    public final f f12960f;

    /* renamed from: g  reason: collision with root package name */
    public int f12961g;

    /* renamed from: c.a.p0.c0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0648a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(int i2, T t);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12955a = null;
        this.f12956b = null;
        this.f12957c = null;
        this.f12958d = null;
        this.f12957c = str;
        this.f12960f = new f(str2);
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12959e : (T) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.f12958d == null) {
            a<T>.c cVar = new c(this, null);
            this.f12958d = cVar;
            cVar.e(z);
            this.f12958d.f(this.f12961g);
            this.f12958d.execute(new String[0]);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f12960f.c(str);
        }
    }

    public void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            this.f12959e = t;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
            LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
            k(msgBPicMaxSize.width, msgBPicMaxSize.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
        }
    }

    public void k(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            this.f12960f.f(i2, i3, i4, i5);
        }
    }

    public void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f12956b = dVar;
        }
    }

    public void m(b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f12955a = new WeakReference<>(bVar);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f12961g = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f12962a;

        /* renamed from: b  reason: collision with root package name */
        public int f12963b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f12964c;

        public c(a aVar) {
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
            this.f12964c = aVar;
            this.f12962a = false;
        }

        @Override // c.a.p0.c0.f.a
        public void a(String str, Object obj, long j2, long j3) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, obj, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                if (j3 == 0) {
                    i2 = 0;
                } else {
                    i2 = (int) ((((float) j2) * 100.0f) / ((float) j3));
                    if (i2 > 100) {
                        i2 = 90;
                    }
                }
                publishProgress(Integer.valueOf(i2));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) ? g() : (ImageUploadResult) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageUploadResult) == null) {
                super.onPostExecute(imageUploadResult);
                this.f12964c.f12958d = null;
                if (this.f12964c.f12956b != null) {
                    if (imageUploadResult == null) {
                        imageUploadResult = new ImageUploadResult();
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                        imageUploadResult.error_msg = string;
                        TiebaStatic.imgError(-1002, string, "");
                    }
                    this.f12964c.f12956b.a(this.f12964c.f12957c, imageUploadResult);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.cancel();
                this.f12964c.f12958d = null;
                this.f12964c.f12960f.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, numArr) == null) || numArr == null || numArr.length == 0 || this.f12964c.f12955a == null || this.f12964c.f12955a.get() == null) {
                return;
            }
            ((b) this.f12964c.f12955a.get()).a(numArr[0].intValue(), this.f12964c.f12959e);
        }

        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                this.f12962a = z;
            }
        }

        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.f12963b = i2;
            }
        }

        public final ImageUploadResult g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                this.f12964c.f12960f.d(this, null);
                this.f12964c.f12960f.g(this.f12963b);
                ImageUploadResult l = this.f12964c.f12960f.l(this.f12964c.f12957c, this.f12962a);
                publishProgress(100);
                return l;
            }
            return (ImageUploadResult) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                super.onPreCancel();
                if (this.f12964c.f12956b != null) {
                    ImageUploadResult imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    this.f12964c.f12956b.a(this.f12964c.f12957c, imageUploadResult);
                }
            }
        }

        public /* synthetic */ c(a aVar, C0648a c0648a) {
            this(aVar);
        }
    }
}
