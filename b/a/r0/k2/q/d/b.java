package b.a.r0.k2.q.d;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.r0.k2.q.d.c;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f18692a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f18693b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f18694c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f18695d;

    /* renamed from: e  reason: collision with root package name */
    public View f18696e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f18697f;

    /* renamed from: g  reason: collision with root package name */
    public View f18698g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f18699h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f18700e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f18701f;

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
            this.f18701f = bVar;
            this.f18700e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.f18700e) == null || post.id == null || this.f18701f.f18699h == null) {
                return;
            }
            this.f18701f.f18699h.a(String.valueOf(this.f18700e.id));
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
        this.f18695d = viewStub;
        this.f18699h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f18696e == null) {
            View inflate = this.f18695d.inflate();
            this.f18696e = inflate;
            this.f18692a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f18693b = (TextView) this.f18696e.findViewById(R.id.chosen_pb_comment_name);
            this.f18694c = (TbRichTextView) this.f18696e.findViewById(R.id.chosen_pb_comment_content);
            this.f18697f = (ImageView) this.f18696e.findViewById(R.id.chosen_pb_comment_reply);
            this.f18698g = this.f18696e.findViewById(R.id.chosen_pb_comment_line);
            this.f18694c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f18693b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f18697f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f18698g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f18694c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f18696e) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public boolean update(Context context, Post post, User user) {
        InterceptResult invokeLLL;
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, post, user)) == null) {
            if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
                b();
                d(true);
                this.f18693b.setText(user.name_show);
                this.f18697f.setOnClickListener(new a(this, post));
                this.f18692a.startLoad(user.portrait, 12, false);
                this.f18694c.setVisibility(0);
                this.f18694c.setText(TbRichTextView.parser(context, post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
