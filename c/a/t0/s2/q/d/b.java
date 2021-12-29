package c.a.t0.s2.q.d;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.t0.s2.q.d.c;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22973b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f22974c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f22975d;

    /* renamed from: e  reason: collision with root package name */
    public View f22976e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f22977f;

    /* renamed from: g  reason: collision with root package name */
    public View f22978g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f22979h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f22980e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f22981f;

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
            this.f22981f = bVar;
            this.f22980e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.f22980e) == null || post.id == null || this.f22981f.f22979h == null) {
                return;
            }
            this.f22981f.f22979h.a(String.valueOf(this.f22980e.id));
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
        this.f22975d = viewStub;
        this.f22979h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22976e == null) {
            View inflate = this.f22975d.inflate();
            this.f22976e = inflate;
            this.a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f22973b = (TextView) this.f22976e.findViewById(R.id.chosen_pb_comment_name);
            this.f22974c = (TbRichTextView) this.f22976e.findViewById(R.id.chosen_pb_comment_content);
            this.f22977f = (ImageView) this.f22976e.findViewById(R.id.chosen_pb_comment_reply);
            this.f22978g = this.f22976e.findViewById(R.id.chosen_pb_comment_line);
            this.f22974c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f22973b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f22977f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f22978g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f22974c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f22976e) == null) {
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
                this.f22973b.setText(user.name_show);
                this.f22977f.setOnClickListener(new a(this, post));
                this.a.startLoad(user.portrait, 12, false);
                this.f22974c.setVisibility(0);
                this.f22974c.setText(TbRichTextView.parser(post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
