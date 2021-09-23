package c.a.r0.j2.g.d;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.r0.j2.g.d.c;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f19559a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19560b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f19561c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f19562d;

    /* renamed from: e  reason: collision with root package name */
    public View f19563e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19564f;

    /* renamed from: g  reason: collision with root package name */
    public View f19565g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f19566h;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f19567e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19568f;

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
            this.f19568f = bVar;
            this.f19567e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.f19567e) == null || post.id == null || this.f19568f.f19566h == null) {
                return;
            }
            this.f19568f.f19566h.a(String.valueOf(this.f19567e.id));
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
        this.f19562d = viewStub;
        this.f19566h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19563e == null) {
            View inflate = this.f19562d.inflate();
            this.f19563e = inflate;
            this.f19559a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f19560b = (TextView) this.f19563e.findViewById(R.id.chosen_pb_comment_name);
            this.f19561c = (TbRichTextView) this.f19563e.findViewById(R.id.chosen_pb_comment_content);
            this.f19564f = (ImageView) this.f19563e.findViewById(R.id.chosen_pb_comment_reply);
            this.f19565g = this.f19563e.findViewById(R.id.chosen_pb_comment_line);
            this.f19561c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f19560b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f19564f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f19565g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f19561c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f19563e) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public boolean e(Context context, Post post, User user) {
        InterceptResult invokeLLL;
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, post, user)) == null) {
            if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
                b();
                d(true);
                this.f19560b.setText(user.name_show);
                this.f19564f.setOnClickListener(new a(this, post));
                this.f19559a.startLoad(user.portrait, 12, false);
                this.f19561c.setVisibility(0);
                this.f19561c.setText(TbRichTextView.parser(context, post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
