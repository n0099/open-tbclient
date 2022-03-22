package c.a.p0.f1.r2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.p0.w2.m.f.e1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14487b;

    /* renamed from: c  reason: collision with root package name */
    public View f14488c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f14489d;

    /* renamed from: e  reason: collision with root package name */
    public ForumData f14490e;

    /* renamed from: f  reason: collision with root package name */
    public b f14491f;

    /* renamed from: g  reason: collision with root package name */
    public e1 f14492g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f14493h;

    /* loaded from: classes2.dex */
    public class a extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14494b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f14495c;

        public a(l lVar, Bitmap bitmap, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, bitmap, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14495c = lVar;
            this.a = bitmap;
            this.f14494b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14495c.e(this.a, this.f14494b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.f14487b = context;
        this.f14488c = view;
        this.f14491f = bVar;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                return true;
            }
            if (this.f14493h == null) {
                this.f14493h = new PermissionJudgePolicy();
            }
            this.f14493h.clearRequestPermissionList();
            this.f14493h.appendRequestPermission(this.a.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.f14493h.startRequestPermission(this.a.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
            g(this.f14489d);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f14489d == null) {
            b bVar = this.f14491f;
            if (bVar != null) {
                bVar.a();
            }
            this.f14488c.buildDrawingCache();
            this.f14489d = this.f14488c.getDrawingCache();
            b bVar2 = this.f14491f;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    public final ShareItem e(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, bitmap, i)) == null) {
            if (this.f14487b == null || this.f14490e == null) {
                return null;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.b0 = 1;
            shareItem.r = this.f14487b.getString(R.string.obfuscated_res_0x7f0f029e);
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

    public /* synthetic */ void f(int i, ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.a.getPageActivity(), i, shareItem, false));
    }

    public final void g(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) || this.a == null || b()) {
            return;
        }
        if (this.f14492g == null) {
            this.f14492g = new e1(this.a);
        }
        ForumData forumData = this.f14490e;
        this.f14492g.b((forumData == null || TextUtils.isEmpty(forumData.forum_share_link)) ? "http://tieba.baidu.com" : this.f14490e.forum_share_link, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void h(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumData) == null) {
            this.f14490e = forumData;
        }
    }

    public final void i(Bitmap bitmap, final int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, bitmap, i) == null) || this.a == null || bitmap == null || b()) {
            return;
        }
        n0.b(new a(this, bitmap, i), new c.a.o0.c1.s() { // from class: c.a.p0.f1.r2.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.o0.c1.s
            public final void onReturnDataInUI(Object obj) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                    l.this.f(i, (ShareItem) obj);
                }
            }
        });
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            d();
            i(this.f14489d, i);
        }
    }
}
