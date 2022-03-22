package c.a.p0.w2.h.d;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.p0.w2.h.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19768b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f19769c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f19770d;

    /* renamed from: e  reason: collision with root package name */
    public View f19771e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19772f;

    /* renamed from: g  reason: collision with root package name */
    public View f19773g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f19774h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Post a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f19775b;

        public a(b bVar, Post post) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, post};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19775b = bVar;
            this.a = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.a) == null || post.id == null || this.f19775b.f19774h == null) {
                return;
            }
            this.f19775b.f19774h.a(String.valueOf(this.a.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19770d = viewStub;
        this.f19774h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19771e == null) {
            View inflate = this.f19770d.inflate();
            this.f19771e = inflate;
            this.a = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09062a);
            this.f19768b = (TextView) this.f19771e.findViewById(R.id.obfuscated_res_0x7f09062c);
            this.f19769c = (TbRichTextView) this.f19771e.findViewById(R.id.obfuscated_res_0x7f090629);
            this.f19772f = (ImageView) this.f19771e.findViewById(R.id.obfuscated_res_0x7f09062d);
            this.f19773g = this.f19771e.findViewById(R.id.obfuscated_res_0x7f09062b);
            this.f19769c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f19768b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f19772f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f19773g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f19769c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f19771e) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public boolean update(Post post, User user) {
        InterceptResult invokeLL;
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, post, user)) == null) {
            if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
                b();
                d(true);
                this.f19768b.setText(user.name_show);
                this.f19772f.setOnClickListener(new a(this, post));
                this.a.J(user.portrait, 12, false);
                this.f19769c.setVisibility(0);
                this.f19769c.setText(TbRichTextView.X(post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
