package c.a.q0.o0.a.g;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f22826a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.o0.a.b f22827b;

    /* renamed from: c.a.q0.o0.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1058a extends BdAsyncTask<Void, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f22828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22829b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22830c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f22831d;

        public C1058a(a aVar, Bitmap bitmap, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bitmap, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22831d = aVar;
            this.f22828a = bitmap;
            this.f22829b = str;
            this.f22830c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                File c2 = this.f22831d.c(this.f22828a, this.f22829b, this.f22830c);
                this.f22828a.recycle();
                return c2.getAbsolutePath();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((C1058a) str);
                if (this.f22831d.f22827b != null) {
                    this.f22831d.f22827b.onCoverPathCallBack(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f22832a;

        /* renamed from: b  reason: collision with root package name */
        public long f22833b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f22834c;

        public b(a aVar, String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22834c = aVar;
            this.f22832a = str;
            this.f22833b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                Bitmap bitmap = null;
                if (TextUtils.isEmpty(this.f22832a)) {
                    return null;
                }
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.f22832a);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(this.f22833b * 1000);
                    mediaMetadataRetriever.release();
                    return bitmap;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return bitmap;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((b) bitmap);
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                a aVar = this.f22834c;
                String str = c.a.q0.w3.c.f28196d;
                aVar.b(bitmap, str, System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX);
            }
        }
    }

    public a() {
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

    public void b(Bitmap bitmap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, bitmap, str, str2) == null) || bitmap == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        new C1058a(this, bitmap, str, str2).execute(new Void[0]);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0057 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0068 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:? */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: android.graphics.Bitmap$CompressFormat */
    /* JADX WARN: Multi-variable type inference failed */
    public File c(Bitmap bitmap, String str, String str2) {
        InterceptResult invokeLLL;
        BufferedOutputStream bufferedOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, str, str2)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (bitmap == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                    bufferedOutputStream.write(byteArrayOutputStream.toByteArray());
                    c.a.e.e.m.a.d(byteArrayOutputStream);
                    byteArrayOutputStream2 = compressFormat;
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    BdLog.e(e);
                    c.a.e.e.m.a.d(byteArrayOutputStream2);
                    byteArrayOutputStream2 = byteArrayOutputStream2;
                    c.a.e.e.m.a.d(bufferedOutputStream);
                    return file2;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    c.a.e.e.m.a.d(byteArrayOutputStream2);
                    c.a.e.e.m.a.d(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
            c.a.e.e.m.a.d(bufferedOutputStream);
            return file2;
        }
        return (File) invokeLLL.objValue;
    }

    public void d(String str, long j2, c.a.q0.o0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j2), bVar}) == null) {
            this.f22827b = bVar;
            b bVar2 = new b(this, str, j2);
            this.f22826a = bVar2;
            bVar2.execute(new Void[0]);
        }
    }
}
