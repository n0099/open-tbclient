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
    public Queue<C0643b> f12016a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f12017b;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.q0.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0643b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f12018a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.q0.c0.b f12019b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12020c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.e.l.d.a f12021d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12022e;

        public C0643b(b bVar) {
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

        public /* synthetic */ C0643b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, C0643b, C0643b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C0643b> f12023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f12024b;

        public c(b bVar, Queue<C0643b> queue) {
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
            this.f12024b = bVar;
            this.f12023a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C0643b doInBackground(Void... voidArr) {
            int i2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (C0643b) invokeL.objValue;
            }
            while (true) {
                C0643b poll = this.f12023a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f12023a.add(poll);
                    return null;
                }
                b.a.e.l.d.a m = b.a.q0.c0.c.k().m(poll.f12018a.toCachedKey(poll.f12020c));
                if (m != null) {
                    poll.f12021d = m;
                    poll.f12022e = true;
                } else {
                    Bitmap f2 = this.f12024b.f(poll.f12018a, poll.f12020c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f12018a.getFilePath());
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
                            poll.f12021d = new b.a.e.l.d.a(bitmap, poll.f12018a.isGif(), poll.f12018a.getFilePath());
                        } else {
                            poll.f12021d = new b.a.e.l.d.a(f2, poll.f12018a.isGif(), poll.f12018a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C0643b c0643b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0643b) == null) {
                super.onPostExecute(c0643b);
                this.f12024b.f12017b = null;
                this.f12024b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C0643b... c0643bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c0643bArr) == null) || c0643bArr == null) {
                return;
            }
            for (C0643b c0643b : c0643bArr) {
                b.a.e.l.d.a aVar = c0643b.f12021d;
                if (aVar != null && !c0643b.f12022e) {
                    b.a.q0.c0.c.k().d(c0643b.f12018a.toCachedKey(c0643b.f12020c), aVar);
                }
                b.a.q0.c0.b bVar = c0643b.f12019b;
                if (bVar != null) {
                    bVar.imageLoaded(aVar, c0643b.f12018a.toCachedKey(c0643b.f12020c), c0643b.f12022e);
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
            this.f12024b.f12017b = null;
            while (true) {
                C0643b poll = this.f12023a.poll();
                if (poll == null) {
                    return;
                }
                b.a.q0.c0.b bVar = poll.f12019b;
                if (bVar != null) {
                    bVar.imageLoaded(null, poll.f12018a.toCachedKey(poll.f12020c), false);
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
        this.f12016a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12016a = new ConcurrentLinkedQueue();
            if (this.f12017b != null) {
                this.f12017b.cancel(true);
                this.f12017b = null;
            }
        }
    }

    public b.a.e.l.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return b.a.q0.c0.c.k().m(imageFileInfo.toCachedKey(z));
        }
        return (b.a.e.l.d.a) invokeLZ.objValue;
    }

    public b.a.e.l.d.a d(ImageFileInfo imageFileInfo, b.a.q0.c0.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, bVar, z)) == null) ? e(imageFileInfo, bVar, z, false) : (b.a.e.l.d.a) invokeLLZ.objValue;
    }

    public b.a.e.l.d.a e(ImageFileInfo imageFileInfo, b.a.q0.c0.b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            b.a.e.l.d.a c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            C0643b c0643b = new C0643b(this, null);
            c0643b.f12019b = bVar;
            c0643b.f12018a = imageFileInfo;
            c0643b.f12020c = z;
            this.f12016a.add(c0643b);
            g();
            return null;
        }
        return (b.a.e.l.d.a) invokeCommon.objValue;
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
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f12017b == null && !this.f12016a.isEmpty()) {
            this.f12017b = new c(this, this.f12016a);
            this.f12017b.execute(new Void[0]);
        }
    }
}
