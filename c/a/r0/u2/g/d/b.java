package c.a.r0.u2.g.d;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.r0.u2.g.d.c;
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
    public TextView f23032b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f23033c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f23034d;

    /* renamed from: e  reason: collision with root package name */
    public View f23035e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f23036f;

    /* renamed from: g  reason: collision with root package name */
    public View f23037g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f23038h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f23039e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f23040f;

        public a(b bVar, Post post) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, post};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23040f = bVar;
            this.f23039e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.f23039e) == null || post.id == null || this.f23040f.f23038h == null) {
                return;
            }
            this.f23040f.f23038h.a(String.valueOf(this.f23039e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23034d = viewStub;
        this.f23038h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23035e == null) {
            View inflate = this.f23034d.inflate();
            this.f23035e = inflate;
            this.a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f23032b = (TextView) this.f23035e.findViewById(R.id.chosen_pb_comment_name);
            this.f23033c = (TbRichTextView) this.f23035e.findViewById(R.id.chosen_pb_comment_content);
            this.f23036f = (ImageView) this.f23035e.findViewById(R.id.chosen_pb_comment_reply);
            this.f23037g = this.f23035e.findViewById(R.id.chosen_pb_comment_line);
            this.f23033c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f23032b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f23036f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f23037g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f23033c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f23035e) == null) {
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
                this.f23032b.setText(user.name_show);
                this.f23036f.setOnClickListener(new a(this, post));
                this.a.startLoad(user.portrait, 12, false);
                this.f23033c.setVisibility(0);
                this.f23033c.setText(TbRichTextView.parser(post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
