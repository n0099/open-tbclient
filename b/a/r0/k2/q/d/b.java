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
    public HeadImageView f20228a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20229b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f20230c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f20231d;

    /* renamed from: e  reason: collision with root package name */
    public View f20232e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20233f;

    /* renamed from: g  reason: collision with root package name */
    public View f20234g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f20235h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f20236e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f20237f;

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
            this.f20237f = bVar;
            this.f20236e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.f20236e) == null || post.id == null || this.f20237f.f20235h == null) {
                return;
            }
            this.f20237f.f20235h.a(String.valueOf(this.f20236e.id));
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
        this.f20231d = viewStub;
        this.f20235h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20232e == null) {
            View inflate = this.f20231d.inflate();
            this.f20232e = inflate;
            this.f20228a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f20229b = (TextView) this.f20232e.findViewById(R.id.chosen_pb_comment_name);
            this.f20230c = (TbRichTextView) this.f20232e.findViewById(R.id.chosen_pb_comment_content);
            this.f20233f = (ImageView) this.f20232e.findViewById(R.id.chosen_pb_comment_reply);
            this.f20234g = this.f20232e.findViewById(R.id.chosen_pb_comment_line);
            this.f20230c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f20229b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f20233f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f20234g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f20230c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f20232e) == null) {
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
                this.f20229b.setText(user.name_show);
                this.f20233f.setOnClickListener(new a(this, post));
                this.f20228a.startLoad(user.portrait, 12, false);
                this.f20230c.setVisibility(0);
                this.f20230c.setText(TbRichTextView.parser(context, post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
