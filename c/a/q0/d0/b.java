package c.a.q0.d0;

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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<C0761b> a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f11822b;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.q0.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0761b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageFileInfo a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.q0.c0.b f11823b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11824c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.d.m.d.a f11825d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11826e;

        public C0761b(b bVar) {
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

        public /* synthetic */ C0761b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, C0761b, C0761b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<C0761b> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f11827b;

        public c(b bVar, Queue<C0761b> queue) {
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
            this.f11827b = bVar;
            this.a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C0761b doInBackground(Void... voidArr) {
            int i2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (C0761b) invokeL.objValue;
            }
            while (true) {
                C0761b poll = this.a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.a.add(poll);
                    return null;
                }
                c.a.d.m.d.a m = c.a.q0.c0.c.k().m(poll.a.toCachedKey(poll.f11824c));
                if (m != null) {
                    poll.f11825d = m;
                    poll.f11826e = true;
                } else {
                    Bitmap f2 = this.f11827b.f(poll.a, poll.f11824c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.a.getFilePath());
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
                            poll.f11825d = new c.a.d.m.d.a(bitmap, poll.a.isGif(), poll.a.getFilePath());
                        } else {
                            poll.f11825d = new c.a.d.m.d.a(f2, poll.a.isGif(), poll.a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C0761b c0761b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0761b) == null) {
                super.onPostExecute(c0761b);
                this.f11827b.f11822b = null;
                this.f11827b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C0761b... c0761bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0761bArr) == null) || c0761bArr == null) {
                return;
            }
            for (C0761b c0761b : c0761bArr) {
                c.a.d.m.d.a aVar = c0761b.f11825d;
                if (aVar != null && !c0761b.f11826e) {
                    c.a.q0.c0.c.k().d(c0761b.a.toCachedKey(c0761b.f11824c), aVar);
                }
                c.a.q0.c0.b bVar = c0761b.f11823b;
                if (bVar != null) {
                    bVar.imageLoaded(aVar, c0761b.a.toCachedKey(c0761b.f11824c), c0761b.f11826e);
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
            this.f11827b.f11822b = null;
            while (true) {
                C0761b poll = this.a.poll();
                if (poll == null) {
                    return;
                }
                c.a.q0.c0.b bVar = poll.f11823b;
                if (bVar != null) {
                    bVar.imageLoaded(null, poll.a.toCachedKey(poll.f11824c), false);
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
        this.a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = new ConcurrentLinkedQueue();
            if (this.f11822b != null) {
                this.f11822b.cancel(true);
                this.f11822b = null;
            }
        }
    }

    public c.a.d.m.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return c.a.q0.c0.c.k().m(imageFileInfo.toCachedKey(z));
        }
        return (c.a.d.m.d.a) invokeLZ.objValue;
    }

    public c.a.d.m.d.a d(ImageFileInfo imageFileInfo, c.a.q0.c0.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, bVar, z)) == null) ? e(imageFileInfo, bVar, z, false) : (c.a.d.m.d.a) invokeLLZ.objValue;
    }

    public c.a.d.m.d.a e(ImageFileInfo imageFileInfo, c.a.q0.c0.b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            c.a.d.m.d.a c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            C0761b c0761b = new C0761b(this, null);
            c0761b.f11823b = bVar;
            c0761b.a = imageFileInfo;
            c0761b.f11824c = z;
            this.a.add(c0761b);
            g();
            return null;
        }
        return (c.a.d.m.d.a) invokeCommon.objValue;
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
                    return c.a.q0.d0.i.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else if (imageFileInfo.hasActions(z)) {
                try {
                    return c.a.q0.d0.i.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f11822b == null && !this.a.isEmpty()) {
            this.f11822b = new c(this, this.a);
            this.f11822b.execute(new Void[0]);
        }
    }
}
