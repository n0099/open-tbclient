package b.q.a;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class u3 extends AsyncTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f33527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f33528b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f33529c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ r5 f33530d;

    public u3(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, r5 r5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, bitmap, compressFormat, r5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33527a = file;
        this.f33528b = bitmap;
        this.f33529c = compressFormat;
        this.f33530d = r5Var;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x003b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0007 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x001e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.graphics.Bitmap] */
    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        Throwable th;
        IOException e2;
        Interceptable interceptable = $ic;
        InterceptResult e3 = interceptable;
        if (interceptable != null) {
            InterceptResult invokeL = interceptable.invokeL(1048576, this, objArr);
            e3 = invokeL;
            if (invokeL != null) {
                return invokeL.objValue;
            }
        }
        Void[] voidArr = (Void[]) objArr;
        FileOutputStream fileOutputStream = null;
        try {
        } catch (Throwable th2) {
            FileOutputStream fileOutputStream2 = e3;
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
        try {
            try {
                e3 = new FileOutputStream(this.f33527a);
            } catch (IOException e4) {
                e3 = e4;
                e3.printStackTrace();
            }
            try {
                this.f33528b.compress(this.f33529c, 100, e3);
                e3.flush();
                e3.close();
                e3 = e3;
            } catch (IOException e5) {
                e2 = e5;
                new com.win.opensdk.k0(e2);
                cancel(true);
                if (e3 != 0) {
                    e3.flush();
                    e3.close();
                    e3 = e3;
                }
                return null;
            }
        } catch (IOException e6) {
            e2 = e6;
            e3 = 0;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f33530d.a();
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Void r5 = (Void) obj;
            this.f33530d.b();
        }
    }
}
