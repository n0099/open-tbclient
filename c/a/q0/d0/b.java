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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Queue<C0649b> f12853a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f12854b;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.q0.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0649b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f12855a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.q0.c0.b f12856b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12857c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.e.l.d.a f12858d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12859e;

        public C0649b(b bVar) {
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

        public /* synthetic */ C0649b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, C0649b, C0649b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C0649b> f12860a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f12861b;

        public c(b bVar, Queue<C0649b> queue) {
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
            this.f12861b = bVar;
            this.f12860a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C0649b doInBackground(Void... voidArr) {
            int i2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (C0649b) invokeL.objValue;
            }
            while (true) {
                C0649b poll = this.f12860a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f12860a.add(poll);
                    return null;
                }
                c.a.e.l.d.a m = c.a.q0.c0.c.k().m(poll.f12855a.toCachedKey(poll.f12857c));
                if (m != null) {
                    poll.f12858d = m;
                    poll.f12859e = true;
                } else {
                    Bitmap f2 = this.f12861b.f(poll.f12855a, poll.f12857c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f12855a.getFilePath());
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
                            poll.f12858d = new c.a.e.l.d.a(bitmap, poll.f12855a.isGif(), poll.f12855a.getFilePath());
                        } else {
                            poll.f12858d = new c.a.e.l.d.a(f2, poll.f12855a.isGif(), poll.f12855a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C0649b c0649b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0649b) == null) {
                super.onPostExecute(c0649b);
                this.f12861b.f12854b = null;
                this.f12861b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C0649b... c0649bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0649bArr) == null) || c0649bArr == null) {
                return;
            }
            for (C0649b c0649b : c0649bArr) {
                c.a.e.l.d.a aVar = c0649b.f12858d;
                if (aVar != null && !c0649b.f12859e) {
                    c.a.q0.c0.c.k().d(c0649b.f12855a.toCachedKey(c0649b.f12857c), aVar);
                }
                c.a.q0.c0.b bVar = c0649b.f12856b;
                if (bVar != null) {
                    bVar.imageLoaded(aVar, c0649b.f12855a.toCachedKey(c0649b.f12857c), c0649b.f12859e);
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
            this.f12861b.f12854b = null;
            while (true) {
                C0649b poll = this.f12860a.poll();
                if (poll == null) {
                    return;
                }
                c.a.q0.c0.b bVar = poll.f12856b;
                if (bVar != null) {
                    bVar.imageLoaded(null, poll.f12855a.toCachedKey(poll.f12857c), false);
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
        this.f12853a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12853a = new ConcurrentLinkedQueue();
            if (this.f12854b != null) {
                this.f12854b.cancel(true);
                this.f12854b = null;
            }
        }
    }

    public c.a.e.l.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return c.a.q0.c0.c.k().m(imageFileInfo.toCachedKey(z));
        }
        return (c.a.e.l.d.a) invokeLZ.objValue;
    }

    public c.a.e.l.d.a d(ImageFileInfo imageFileInfo, c.a.q0.c0.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, bVar, z)) == null) ? e(imageFileInfo, bVar, z, false) : (c.a.e.l.d.a) invokeLLZ.objValue;
    }

    public c.a.e.l.d.a e(ImageFileInfo imageFileInfo, c.a.q0.c0.b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            c.a.e.l.d.a c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            C0649b c0649b = new C0649b(this, null);
            c0649b.f12856b = bVar;
            c0649b.f12855a = imageFileInfo;
            c0649b.f12857c = z;
            this.f12853a.add(c0649b);
            g();
            return null;
        }
        return (c.a.e.l.d.a) invokeCommon.objValue;
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f12854b == null && !this.f12853a.isEmpty()) {
            this.f12854b = new c(this, this.f12853a);
            this.f12854b.execute(new Void[0]);
        }
    }
}
