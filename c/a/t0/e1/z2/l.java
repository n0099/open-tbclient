package c.a.t0.e1.z2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.d1.k0;
import c.a.s0.d1.n0;
import c.a.t0.e1.i1;
import c.a.t0.t2.u.f.y0;
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
    public Context f17359b;

    /* renamed from: c  reason: collision with root package name */
    public View f17360c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f17361d;

    /* renamed from: e  reason: collision with root package name */
    public ForumData f17362e;

    /* renamed from: f  reason: collision with root package name */
    public b f17363f;

    /* renamed from: g  reason: collision with root package name */
    public y0 f17364g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f17365h;

    /* loaded from: classes7.dex */
    public class a extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f17366b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f17367c;

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
            this.f17367c = lVar;
            this.a = bitmap;
            this.f17366b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.d1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f17367c.e(this.a, this.f17366b) : (ShareItem) invokeV.objValue;
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
        this.f17359b = context;
        this.f17360c = view;
        this.f17363f = bVar;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                return true;
            }
            if (this.f17365h == null) {
                this.f17365h = new PermissionJudgePolicy();
            }
            this.f17365h.clearRequestPermissionList();
            this.f17365h.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.f17365h.startRequestPermission(this.a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
            g(this.f17361d);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f17361d == null) {
            b bVar = this.f17363f;
            if (bVar != null) {
                bVar.a();
            }
            this.f17360c.buildDrawingCache();
            this.f17361d = this.f17360c.getDrawingCache();
            b bVar2 = this.f17363f;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    public final ShareItem e(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bitmap, i2)) == null) {
            if (this.f17359b == null || this.f17362e == null) {
                return null;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.b0 = 1;
            shareItem.r = this.f17359b.getString(i1.app_name);
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
        if (this.f17364g == null) {
            this.f17364g = new y0(this.a);
        }
        ForumData forumData = this.f17362e;
        this.f17364g.b((forumData == null || TextUtils.isEmpty(forumData.forum_share_link)) ? "http://tieba.baidu.com" : this.f17362e.forum_share_link, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void h(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumData) == null) {
            this.f17362e = forumData;
        }
    }

    public final void i(Bitmap bitmap, final int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, bitmap, i2) == null) || this.a == null || bitmap == null || b()) {
            return;
        }
        n0.b(new a(this, bitmap, i2), new c.a.s0.d1.s() { // from class: c.a.t0.e1.z2.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.s0.d1.s
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
            i(this.f17361d, i2);
        }
    }
}
