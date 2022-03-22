package c.a.a0.l0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class g implements i<ImageView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, h> f1408c;

    /* renamed from: d  reason: collision with root package name */
    public final Lock f1409d;

    /* loaded from: classes.dex */
    public class a implements InterfaceC0057g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f1410b;

        /* renamed from: c.a.a0.l0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0056a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f1411b;

            public RunnableC0056a(a aVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1411b = aVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1411b.a.setImageBitmap(this.a);
                    this.f1411b.a.setBackgroundResource(17170445);
                    this.f1411b.a.setVisibility(0);
                }
            }
        }

        public a(g gVar, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1410b = gVar;
            this.a = imageView;
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setImageDrawable(this.f1410b.l(this.a));
            }
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                c.a.a0.h.k.b(new RunnableC0056a(this, bitmap));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.a0.u.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f1412b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f1413c;

        public b(g gVar, String str, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1413c = gVar;
            this.a = str;
            this.f1412b = hVar;
        }

        @Override // c.a.a0.u.p.a
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.f1413c.f1409d.lock();
                try {
                    this.f1413c.f1408c.remove(this.a);
                    this.f1412b.a();
                } finally {
                    this.f1413c.f1409d.unlock();
                }
            }
        }

        @Override // c.a.a0.u.p.a
        public void c(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap decodeStream = BitmapFactory.decodeStream(new f(inputStream), null, options);
                if (decodeStream == null) {
                    this.f1413c.f1409d.lock();
                    try {
                        this.f1413c.f1408c.remove(this.a);
                        this.f1412b.a();
                        return;
                    } finally {
                    }
                }
                String str = this.a;
                Bitmap p = !str.substring(str.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? g.p(g.q(decodeStream, 100 - (this.f1413c.r(decodeStream) * 10)), g.s(options)) : decodeStream;
                if (p != null) {
                    decodeStream = p;
                }
                c.a.a0.e.a.d().j(this.a, decodeStream);
                this.f1413c.f1409d.lock();
                try {
                    this.f1413c.f1408c.remove(this.a);
                    this.f1412b.b(decodeStream);
                } finally {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements InterfaceC0057g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f1414b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f1415c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f1416d;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f1417b;

            public a(c cVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1417b = cVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f1417b.a.setImageBitmap(this.a);
                    c cVar = this.f1417b;
                    int i = cVar.f1415c;
                    if (i >= 0) {
                        cVar.a.setAlpha(i / 100.0f);
                    }
                }
            }
        }

        public c(g gVar, ImageView imageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, imageView, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1416d = gVar;
            this.a = imageView;
            this.f1414b = i;
            this.f1415c = i2;
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.post(new a(this, this.f1416d.k(this.a, bitmap, this.f1414b, this.f1415c)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements InterfaceC0057g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.r.b a;

        public d(g gVar, c.a.a0.r.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.b(bitmap);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements InterfaceC0057g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.r.b a;

        public e(g gVar, c.a.a0.r.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.b(bitmap);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long j2 = 0;
                while (j2 < j) {
                    long skip = ((FilterInputStream) this).in.skip(j - j2);
                    if (skip == 0) {
                        if (read() < 0) {
                            break;
                        }
                        skip = 1;
                    }
                    j2 += skip;
                }
                return j2;
            }
            return invokeJ.longValue;
        }
    }

    /* renamed from: c.a.a0.l0.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057g {
        void a();

        void b(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public static final class h implements InterfaceC0057g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<InterfaceC0057g> a;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new LinkedList();
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (InterfaceC0057g interfaceC0057g : this.a) {
                    interfaceC0057g.a();
                }
            }
        }

        @Override // c.a.a0.l0.g.InterfaceC0057g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                for (InterfaceC0057g interfaceC0057g : this.a) {
                    interfaceC0057g.b(bitmap);
                }
            }
        }

        public void c(@Nullable InterfaceC0057g interfaceC0057g) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0057g) == null) || interfaceC0057g == null) {
                return;
            }
            c.a.a0.x.a.b(this.a, interfaceC0057g);
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1408c = new ConcurrentHashMap();
        this.f1409d = new ReentrantLock();
    }

    public static int j(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public static Bitmap p(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bitmap, i)) == null) {
            if (i <= 1) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f2 = 1.0f / i;
            matrix.postScale(f2, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap q(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bitmap, i)) == null) {
            if (i == 100) {
                return bitmap;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            try {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static int s(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, options)) == null) {
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i2 > 1140 || i3 > 1140) {
                int i4 = 2;
                int i5 = i2 / 2;
                int i6 = i3 / 2;
                while (true) {
                    if (i5 < 1140 && i6 < 1140) {
                        break;
                    }
                    i4 *= 2;
                }
                i = i4;
            } else {
                i = 1;
            }
            if (i > 6) {
                return 6;
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // c.a.a0.l0.i
    public void a(String str, ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(1048576, this, str, imageView, i, i2) == null) || imageView == null) {
            return;
        }
        Bitmap h2 = c.a.a0.e.a.d().h(str);
        if (h2 == null) {
            n(str, new c(this, imageView, i, i2));
            return;
        }
        imageView.setImageBitmap(k(imageView, h2, i, i2));
        if (i2 >= 0) {
            imageView.setAlpha(i2 / 100.0f);
        }
    }

    @Override // c.a.a0.r.c
    public void b(String str, c.a.a0.r.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) || bVar == null) {
            return;
        }
        Bitmap h2 = c.a.a0.e.a.d().h(str);
        if (h2 == null) {
            n(str, new e(this, bVar));
        } else {
            bVar.b(h2);
        }
    }

    @Override // c.a.a0.r.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && c.a.a0.e.a.d().h(str) == null) {
            n(str, null);
        }
    }

    @Override // c.a.a0.l0.i
    public void d(@NonNull String str, c.a.a0.r.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            Bitmap h2 = c.a.a0.e.a.d().h(str);
            if (h2 == null) {
                n(str, new d(this, bVar));
            } else {
                bVar.b(h2);
            }
        }
    }

    @Override // c.a.a0.l0.i
    public void e(String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, imageView) == null) || imageView == null) {
            return;
        }
        Bitmap h2 = c.a.a0.e.a.d().h(str);
        if (h2 == null) {
            imageView.setImageDrawable(m(imageView));
            n(str, new a(this, imageView));
            return;
        }
        imageView.setImageBitmap(h2);
        imageView.setBackgroundResource(17170445);
        imageView.setVisibility(0);
    }

    public final Bitmap k(View view, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048581, this, view, bitmap, i, i2)) == null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(view.getContext());
            if (Build.VERSION.SDK_INT >= 17) {
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(i);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public final Drawable l(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            if (!(view instanceof AdImageView)) {
                return c.a.a0.l0.b.b().a(view.getContext());
            }
            int i = ((AdImageView) view).getConfig().f1426c;
            if (i != 0) {
                return view.getResources().getDrawable(i);
            }
            return c.a.a0.l0.b.b().a(view.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final Drawable m(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            if (!(view instanceof AdImageView)) {
                return c.a.a0.l0.b.b().b(view.getContext());
            }
            AdImageView adImageView = (AdImageView) view;
            if (adImageView.getConfig().f1425b != null) {
                return adImageView.getConfig().f1425b;
            }
            int i = adImageView.getConfig().a;
            if (i != 0) {
                return view.getResources().getDrawable(i);
            }
            return c.a.a0.l0.b.b().b(view.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final void n(String str, @Nullable InterfaceC0057g interfaceC0057g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, interfaceC0057g) == null) {
            this.f1409d.lock();
            try {
                h hVar = this.f1408c.get(str);
                if (hVar == null) {
                    h hVar2 = new h();
                    this.f1408c.put(str, hVar2);
                    hVar2.c(interfaceC0057g);
                    o(str, hVar2);
                } else {
                    c.a.a0.i.a.a(ImageLoader.TAG, DataEntryUrlBox.TYPE + str + " cached connection!");
                    hVar.c(interfaceC0057g);
                }
            } finally {
                this.f1409d.unlock();
            }
        }
    }

    public final void o(String str, @NonNull h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, hVar) == null) {
            c.a.a0.u.s.d dVar = new c.a.a0.u.s.d();
            dVar.k(str);
            dVar.c();
            c.a.a0.u.g.b().a().b(dVar, new b(this, str, hVar));
        }
    }

    public int r(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bitmap)) == null) {
            int j = j(bitmap);
            if (j > 2457600) {
                int i = j / 2457600;
                if (i > 6) {
                    return 6;
                }
                return i;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
