package c.a.c0.k0;

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
public class f implements h<ImageView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, g> f2111c;

    /* renamed from: d  reason: collision with root package name */
    public final Lock f2112d;

    /* loaded from: classes.dex */
    public class a implements InterfaceC0084f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f2113b;

        /* renamed from: c.a.c0.k0.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0083a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f2114e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f2115f;

            public RunnableC0083a(a aVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2115f = aVar;
                this.f2114e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f2115f.a.setImageBitmap(this.f2114e);
                    this.f2115f.a.setBackgroundResource(17170445);
                    this.f2115f.a.setVisibility(0);
                }
            }
        }

        public a(f fVar, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2113b = fVar;
            this.a = imageView;
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setImageDrawable(this.f2113b.k(this.a));
            }
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                c.a.c0.h.k.b(new RunnableC0083a(this, bitmap));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.c0.u.p.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f2116b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f2117c;

        public b(f fVar, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2117c = fVar;
            this.a = str;
            this.f2116b = gVar;
        }

        @Override // c.a.c0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                this.f2117c.f2112d.lock();
                try {
                    this.f2117c.f2111c.remove(this.a);
                    this.f2116b.a();
                } finally {
                    this.f2117c.f2112d.unlock();
                }
            }
        }

        @Override // c.a.c0.u.p.a
        public void c(Headers headers, InputStream inputStream, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i2) == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap decodeStream = BitmapFactory.decodeStream(new e(inputStream), null, options);
                if (decodeStream == null) {
                    this.f2117c.f2112d.lock();
                    try {
                        this.f2117c.f2111c.remove(this.a);
                        this.f2116b.a();
                        return;
                    } finally {
                    }
                }
                String str = this.a;
                Bitmap o = !str.substring(str.lastIndexOf("/") + 1).toUpperCase().contains("PNG") ? f.o(f.p(decodeStream, 100 - (this.f2117c.q(decodeStream) * 10)), f.r(options)) : decodeStream;
                if (o != null) {
                    decodeStream = o;
                }
                c.a.c0.e.a.d().j(this.a, decodeStream);
                this.f2117c.f2112d.lock();
                try {
                    this.f2117c.f2111c.remove(this.a);
                    this.f2116b.b(decodeStream);
                } finally {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements InterfaceC0084f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2118b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2119c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f2120d;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f2121e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f2122f;

            public a(c cVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2122f = cVar;
                this.f2121e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f2122f.a.setImageBitmap(this.f2121e);
                    c cVar = this.f2122f;
                    int i2 = cVar.f2119c;
                    if (i2 >= 0) {
                        cVar.a.setAlpha(i2 / 100.0f);
                    }
                }
            }
        }

        public c(f fVar, ImageView imageView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, imageView, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2120d = fVar;
            this.a = imageView;
            this.f2118b = i2;
            this.f2119c = i3;
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.post(new a(this, this.f2120d.j(this.a, bitmap, this.f2118b, this.f2119c)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements InterfaceC0084f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.c0.r.b a;

        public d(f fVar, c.a.c0.r.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.b(bitmap);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j2) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                long j3 = 0;
                while (j3 < j2) {
                    long skip = ((FilterInputStream) this).in.skip(j2 - j3);
                    if (skip == 0) {
                        if (read() < 0) {
                            break;
                        }
                        skip = 1;
                    }
                    j3 += skip;
                }
                return j3;
            }
            return invokeJ.longValue;
        }
    }

    /* renamed from: c.a.c0.k0.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0084f {
        void a();

        void b(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public static final class g implements InterfaceC0084f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<InterfaceC0084f> a;

        public g() {
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
            this.a = new LinkedList();
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (InterfaceC0084f interfaceC0084f : this.a) {
                    interfaceC0084f.a();
                }
            }
        }

        @Override // c.a.c0.k0.f.InterfaceC0084f
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                for (InterfaceC0084f interfaceC0084f : this.a) {
                    interfaceC0084f.b(bitmap);
                }
            }
        }

        public void c(@Nullable InterfaceC0084f interfaceC0084f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0084f) == null) || interfaceC0084f == null) {
                return;
            }
            c.a.c0.x.a.b(this.a, interfaceC0084f);
        }
    }

    public f() {
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
        this.f2111c = new ConcurrentHashMap();
        this.f2112d = new ReentrantLock();
    }

    public static int i(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i2 >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public static Bitmap o(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bitmap, i2)) == null) {
            if (i2 <= 1) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f2 = 1.0f / i2;
            matrix.postScale(f2, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap p(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bitmap, i2)) == null) {
            if (i2 == 100) {
                return bitmap;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
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

    public static int r(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, options)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 > 1140 || i4 > 1140) {
                int i5 = 2;
                int i6 = i3 / 2;
                int i7 = i4 / 2;
                while (true) {
                    if (i6 < 1140 && i7 < 1140) {
                        break;
                    }
                    i5 *= 2;
                }
                i2 = i5;
            } else {
                i2 = 1;
            }
            if (i2 > 6) {
                return 6;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    @Override // c.a.c0.k0.h
    public void a(String str, ImageView imageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(1048576, this, str, imageView, i2, i3) == null) || imageView == null) {
            return;
        }
        Bitmap h2 = c.a.c0.e.a.d().h(str);
        if (h2 == null) {
            m(str, new c(this, imageView, i2, i3));
            return;
        }
        imageView.setImageBitmap(j(imageView, h2, i2, i3));
        if (i3 >= 0) {
            imageView.setAlpha(i3 / 100.0f);
        }
    }

    @Override // c.a.c0.r.c
    public void b(String str, c.a.c0.r.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar) == null) || bVar == null) {
            return;
        }
        Bitmap h2 = c.a.c0.e.a.d().h(str);
        if (h2 == null) {
            m(str, new d(this, bVar));
        } else {
            bVar.b(h2);
        }
    }

    @Override // c.a.c0.r.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && c.a.c0.e.a.d().h(str) == null) {
            m(str, null);
        }
    }

    @Override // c.a.c0.k0.h
    public void d(String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, imageView) == null) || imageView == null) {
            return;
        }
        Bitmap h2 = c.a.c0.e.a.d().h(str);
        if (h2 == null) {
            imageView.setImageDrawable(l(imageView));
            m(str, new a(this, imageView));
            return;
        }
        imageView.setImageBitmap(h2);
        imageView.setBackgroundResource(17170445);
        imageView.setVisibility(0);
    }

    public final Bitmap j(View view, Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048580, this, view, bitmap, i2, i3)) == null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(view.getContext());
            if (Build.VERSION.SDK_INT >= 17) {
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(i2);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public final Drawable k(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) {
            if (!(view instanceof AdImageView)) {
                return c.a.c0.k0.b.b().a(view.getContext());
            }
            int i2 = ((AdImageView) view).getConfig().f2135c;
            if (i2 != 0) {
                return view.getResources().getDrawable(i2);
            }
            return c.a.c0.k0.b.b().a(view.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final Drawable l(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            if (!(view instanceof AdImageView)) {
                return c.a.c0.k0.b.b().b(view.getContext());
            }
            AdImageView adImageView = (AdImageView) view;
            if (adImageView.getConfig().f2134b != null) {
                return adImageView.getConfig().f2134b;
            }
            int i2 = adImageView.getConfig().a;
            if (i2 != 0) {
                return view.getResources().getDrawable(i2);
            }
            return c.a.c0.k0.b.b().b(view.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final void m(String str, @Nullable InterfaceC0084f interfaceC0084f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, interfaceC0084f) == null) {
            this.f2112d.lock();
            try {
                g gVar = this.f2111c.get(str);
                if (gVar == null) {
                    g gVar2 = new g();
                    this.f2111c.put(str, gVar2);
                    gVar2.c(interfaceC0084f);
                    n(str, gVar2);
                } else {
                    c.a.c0.i.a.a(ImageLoader.TAG, DataEntryUrlBox.TYPE + str + " cached connection!");
                    gVar.c(interfaceC0084f);
                }
            } finally {
                this.f2112d.unlock();
            }
        }
    }

    public final void n(String str, @NonNull g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, gVar) == null) {
            c.a.c0.u.s.d dVar = new c.a.c0.u.s.d();
            dVar.k(str);
            dVar.c();
            c.a.c0.u.g.b().a().b(dVar, new b(this, str, gVar));
        }
    }

    public int q(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            int i2 = i(bitmap);
            if (i2 > 2457600) {
                int i3 = i2 / 2457600;
                if (i3 > 6) {
                    return 6;
                }
                return i3;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
