package b.a.q0.d0;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Queue<C0677b> f12895a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f12896b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.q0.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0677b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f12897a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.q0.c0.b f12898b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12899c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.e.m.d.a f12900d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12901e;

        public C0677b(b bVar) {
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

        public /* synthetic */ C0677b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, C0677b, C0677b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C0677b> f12902a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f12903b;

        public c(b bVar, Queue<C0677b> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12903b = bVar;
            this.f12902a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C0677b doInBackground(Void... voidArr) {
            int i2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (C0677b) invokeL.objValue;
            }
            while (true) {
                C0677b poll = this.f12902a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f12902a.add(poll);
                    return null;
                }
                b.a.e.m.d.a m = b.a.q0.c0.c.k().m(poll.f12897a.toCachedKey(poll.f12899c));
                if (m != null) {
                    poll.f12900d = m;
                    poll.f12901e = true;
                } else {
                    Bitmap f2 = this.f12903b.f(poll.f12897a, poll.f12899c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f12897a.getFilePath());
                            if (i2 != 0) {
                                try {
                                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(f2, i2);
                                    if (f2 != rotateBitmapBydegree) {
                                        try {
                                            f2.recycle();
                                            f2 = null;
                                        } catch (Exception unused) {
                                        }
                                    }
                                    bitmap = rotateBitmapBydegree;
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        if (i2 != 0 && bitmap != null) {
                            poll.f12900d = new b.a.e.m.d.a(bitmap, poll.f12897a.isGif(), poll.f12897a.getFilePath());
                        } else {
                            poll.f12900d = new b.a.e.m.d.a(f2, poll.f12897a.isGif(), poll.f12897a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C0677b c0677b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0677b) == null) {
                super.onPostExecute(c0677b);
                this.f12903b.f12896b = null;
                this.f12903b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C0677b... c0677bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0677bArr) == null) || c0677bArr == null) {
                return;
            }
            for (C0677b c0677b : c0677bArr) {
                b.a.e.m.d.a aVar = c0677b.f12900d;
                if (aVar != null && !c0677b.f12901e) {
                    b.a.q0.c0.c.k().d(c0677b.f12897a.toCachedKey(c0677b.f12899c), aVar);
                }
                b.a.q0.c0.b bVar = c0677b.f12898b;
                if (bVar != null) {
                    bVar.imageLoaded(aVar, c0677b.f12897a.toCachedKey(c0677b.f12899c), c0677b.f12901e);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
                return;
            }
            super.onCancelled();
            this.f12903b.f12896b = null;
            while (true) {
                C0677b poll = this.f12902a.poll();
                if (poll == null) {
                    return;
                }
                b.a.q0.c0.b bVar = poll.f12898b;
                if (bVar != null) {
                    bVar.imageLoaded(null, poll.f12897a.toCachedKey(poll.f12899c), false);
                }
            }
        }
    }

    public b() {
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
        this.f12895a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12895a = new ConcurrentLinkedQueue();
            if (this.f12896b != null) {
                this.f12896b.cancel(true);
                this.f12896b = null;
            }
        }
    }

    public b.a.e.m.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return b.a.q0.c0.c.k().m(imageFileInfo.toCachedKey(z));
        }
        return (b.a.e.m.d.a) invokeLZ.objValue;
    }

    public b.a.e.m.d.a d(ImageFileInfo imageFileInfo, b.a.q0.c0.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, bVar, z)) == null) ? e(imageFileInfo, bVar, z, false) : (b.a.e.m.d.a) invokeLLZ.objValue;
    }

    public b.a.e.m.d.a e(ImageFileInfo imageFileInfo, b.a.q0.c0.b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            b.a.e.m.d.a c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            C0677b c0677b = new C0677b(this, null);
            c0677b.f12898b = bVar;
            c0677b.f12897a = imageFileInfo;
            c0677b.f12899c = z;
            this.f12895a.add(c0677b);
            g();
            return null;
        }
        return (b.a.e.m.d.a) invokeCommon.objValue;
    }

    public Bitmap f(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            if (z && imageFileInfo.getPersistActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPersistActionsList());
            }
            if (imageFileInfo.getPageActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPageActionsList());
            }
            if (imageFileInfo.getOrginalBitmap() != null) {
                try {
                    return b.a.q0.d0.i.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else if (imageFileInfo.hasActions(z)) {
                try {
                    return b.a.q0.d0.i.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            } else {
                return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
            }
        }
        return (Bitmap) invokeLZ.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f12896b == null && !this.f12895a.isEmpty()) {
            this.f12896b = new c(this, this.f12895a);
            this.f12896b.execute(new Void[0]);
        }
    }
}
