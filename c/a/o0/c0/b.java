package c.a.o0.c0;

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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Queue<C0639b> f12693a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f12694b;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.o0.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0639b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f12695a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.o0.b0.b f12696b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12697c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.e.k.d.a f12698d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12699e;

        public C0639b(b bVar) {
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

        public /* synthetic */ C0639b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C0639b, C0639b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C0639b> f12700a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f12701b;

        public c(b bVar, Queue<C0639b> queue) {
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
            this.f12701b = bVar;
            this.f12700a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C0639b doInBackground(Void... voidArr) {
            int i2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (C0639b) invokeL.objValue;
            }
            while (true) {
                C0639b poll = this.f12700a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f12700a.add(poll);
                    return null;
                }
                c.a.e.k.d.a m = c.a.o0.b0.c.k().m(poll.f12695a.toCachedKey(poll.f12697c));
                if (m != null) {
                    poll.f12698d = m;
                    poll.f12699e = true;
                } else {
                    Bitmap f2 = this.f12701b.f(poll.f12695a, poll.f12697c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f12695a.getFilePath());
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
                            poll.f12698d = new c.a.e.k.d.a(bitmap, poll.f12695a.isGif(), poll.f12695a.getFilePath());
                        } else {
                            poll.f12698d = new c.a.e.k.d.a(f2, poll.f12695a.isGif(), poll.f12695a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C0639b c0639b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0639b) == null) {
                super.onPostExecute(c0639b);
                this.f12701b.f12694b = null;
                this.f12701b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C0639b... c0639bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0639bArr) == null) || c0639bArr == null) {
                return;
            }
            for (C0639b c0639b : c0639bArr) {
                c.a.e.k.d.a aVar = c0639b.f12698d;
                if (aVar != null && !c0639b.f12699e) {
                    c.a.o0.b0.c.k().d(c0639b.f12695a.toCachedKey(c0639b.f12697c), aVar);
                }
                c.a.o0.b0.b bVar = c0639b.f12696b;
                if (bVar != null) {
                    bVar.imageLoaded(aVar, c0639b.f12695a.toCachedKey(c0639b.f12697c), c0639b.f12699e);
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
            this.f12701b.f12694b = null;
            while (true) {
                C0639b poll = this.f12700a.poll();
                if (poll == null) {
                    return;
                }
                c.a.o0.b0.b bVar = poll.f12696b;
                if (bVar != null) {
                    bVar.imageLoaded(null, poll.f12695a.toCachedKey(poll.f12697c), false);
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
        this.f12693a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12693a = new ConcurrentLinkedQueue();
            if (this.f12694b != null) {
                this.f12694b.cancel(true);
                this.f12694b = null;
            }
        }
    }

    public c.a.e.k.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return c.a.o0.b0.c.k().m(imageFileInfo.toCachedKey(z));
        }
        return (c.a.e.k.d.a) invokeLZ.objValue;
    }

    public c.a.e.k.d.a d(ImageFileInfo imageFileInfo, c.a.o0.b0.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, bVar, z)) == null) ? e(imageFileInfo, bVar, z, false) : (c.a.e.k.d.a) invokeLLZ.objValue;
    }

    public c.a.e.k.d.a e(ImageFileInfo imageFileInfo, c.a.o0.b0.b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            c.a.e.k.d.a c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            C0639b c0639b = new C0639b(this, null);
            c0639b.f12696b = bVar;
            c0639b.f12695a = imageFileInfo;
            c0639b.f12697c = z;
            this.f12693a.add(c0639b);
            g();
            return null;
        }
        return (c.a.e.k.d.a) invokeCommon.objValue;
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
                    return c.a.o0.c0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else if (imageFileInfo.hasActions(z)) {
                try {
                    return c.a.o0.c0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f12694b == null && !this.f12693a.isEmpty()) {
            this.f12694b = new c(this, this.f12693a);
            this.f12694b.execute(new Void[0]);
        }
    }
}
