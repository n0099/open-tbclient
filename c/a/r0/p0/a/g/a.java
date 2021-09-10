package c.a.r0.p0.a.g;

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
    public b f23416a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.p0.a.b f23417b;

    /* renamed from: c.a.r0.p0.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1093a extends BdAsyncTask<Void, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f23418a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f23419b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23420c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f23421d;

        public C1093a(a aVar, Bitmap bitmap, String str, String str2) {
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
            this.f23421d = aVar;
            this.f23418a = bitmap;
            this.f23419b = str;
            this.f23420c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                File c2 = this.f23421d.c(this.f23418a, this.f23419b, this.f23420c);
                this.f23418a.recycle();
                return c2.getAbsolutePath();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((C1093a) str);
                if (this.f23421d.f23417b != null) {
                    this.f23421d.f23417b.onCoverPathCallBack(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f23422a;

        /* renamed from: b  reason: collision with root package name */
        public long f23423b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f23424c;

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
            this.f23424c = aVar;
            this.f23422a = str;
            this.f23423b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                Bitmap bitmap = null;
                if (TextUtils.isEmpty(this.f23422a)) {
                    return null;
                }
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.f23422a);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(this.f23423b * 1000);
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
                a aVar = this.f23424c;
                String str = c.a.r0.x3.c.f28883d;
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
        new C1093a(this, bitmap, str, str2).execute(new Void[0]);
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

    public void d(String str, long j2, c.a.r0.p0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j2), bVar}) == null) {
            this.f23417b = bVar;
            b bVar2 = new b(this, str, j2);
            this.f23416a = bVar2;
            bVar2.execute(new Void[0]);
        }
    }
}
