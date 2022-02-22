package c.a.u0.e1.b3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.l0;
import c.a.t0.d1.o0;
import c.a.u0.e1.i1;
import c.a.u0.u2.u.f.y0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f16182b;

    /* renamed from: c  reason: collision with root package name */
    public View f16183c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f16184d;

    /* renamed from: e  reason: collision with root package name */
    public ForumData f16185e;

    /* renamed from: f  reason: collision with root package name */
    public b f16186f;

    /* renamed from: g  reason: collision with root package name */
    public y0 f16187g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f16188h;

    /* loaded from: classes7.dex */
    public class a extends l0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16189b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f16190c;

        public a(l lVar, Bitmap bitmap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, bitmap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16190c = lVar;
            this.a = bitmap;
            this.f16189b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.d1.l0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16190c.e(this.a, this.f16189b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b();
    }

    public l(TbPageContext tbPageContext, Context context, View view, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, context, view, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f16182b = context;
        this.f16183c = view;
        this.f16186f = bVar;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                return true;
            }
            if (this.f16188h == null) {
                this.f16188h = new PermissionJudgePolicy();
            }
            this.f16188h.clearRequestPermissionList();
            this.f16188h.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.f16188h.startRequestPermission(this.a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
            g(this.f16184d);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f16184d == null) {
            b bVar = this.f16186f;
            if (bVar != null) {
                bVar.a();
            }
            this.f16183c.buildDrawingCache();
            this.f16184d = this.f16183c.getDrawingCache();
            b bVar2 = this.f16186f;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    public final ShareItem e(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bitmap, i2)) == null) {
            if (this.f16182b == null || this.f16185e == null) {
                return null;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.b0 = 1;
            shareItem.r = this.f16182b.getString(i1.app_name);
            shareItem.s = "";
            shareItem.i(bitmap);
            shareItem.g();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_locate", 21);
            shareItem.k(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLI.objValue;
    }

    public /* synthetic */ void f(int i2, ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a.getPageActivity(), i2, shareItem, false));
    }

    public final void g(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) || this.a == null || b()) {
            return;
        }
        if (this.f16187g == null) {
            this.f16187g = new y0(this.a);
        }
        ForumData forumData = this.f16185e;
        this.f16187g.b((forumData == null || TextUtils.isEmpty(forumData.forum_share_link)) ? "http://tieba.baidu.com" : this.f16185e.forum_share_link, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void h(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumData) == null) {
            this.f16185e = forumData;
        }
    }

    public final void i(Bitmap bitmap, final int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, bitmap, i2) == null) || this.a == null || bitmap == null || b()) {
            return;
        }
        o0.b(new a(this, bitmap, i2), new c.a.t0.d1.s() { // from class: c.a.u0.e1.b3.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.t0.d1.s
            public final void onReturnDataInUI(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    l.this.f(i2, (ShareItem) obj);
                }
            }
        });
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            d();
            i(this.f16184d, i2);
        }
    }
}
