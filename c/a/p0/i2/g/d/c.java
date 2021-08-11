package c.a.p0.i2.g.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f18672a;

    /* renamed from: b  reason: collision with root package name */
    public View f18673b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18674c;

    /* renamed from: d  reason: collision with root package name */
    public b f18675d;

    /* renamed from: e  reason: collision with root package name */
    public b f18676e;

    /* renamed from: f  reason: collision with root package name */
    public b f18677f;

    /* renamed from: g  reason: collision with root package name */
    public View f18678g;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str);
    }

    public c(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.chosen_pb_comment_layout, (ViewGroup) null);
        this.f18673b = inflate;
        this.f18674c = (TextView) inflate.findViewById(R.id.chosen_pb_comment_title);
        this.f18678g = this.f18673b.findViewById(R.id.chosen_pb_comment_line);
        this.f18672a = this.f18673b.findViewById(R.id.comment_layout_blank_view);
        this.f18675d = new b((ViewStub) this.f18673b.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.f18676e = new b((ViewStub) this.f18673b.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.f18677f = new b((ViewStub) this.f18673b.findViewById(R.id.chosen_pb_commrnt_third), aVar);
    }

    public final User a(Post post, List<User> list) {
        InterceptResult invokeLL;
        Long l;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, post, list)) == null) {
            if (post == null || list == null || list.isEmpty() || (l = post.author_id) == null) {
                return null;
            }
            long longValue = l.longValue();
            for (User user : list) {
                if (user != null && (l2 = user.id) != null && l2.longValue() == longValue) {
                    return user;
                }
            }
            return null;
        }
        return (User) invokeLL.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18673b : (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.f18673b, R.color.common_color_10187);
            SkinManager.setBackgroundColor(this.f18672a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f18674c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f18678g, R.color.CAM_X0204);
            this.f18675d.c();
            this.f18676e.c();
            this.f18677f.c();
        }
    }

    public void d(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean e2;
        boolean e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                this.f18678g.setVisibility(0);
                int size = list.size();
                if (size != 1) {
                    if (size == 2) {
                        boolean e4 = this.f18675d.e(context, list.get(0), a(list.get(0), list2));
                        boolean e5 = this.f18676e.e(context, list.get(1), a(list.get(1), list2));
                        this.f18677f.d(false);
                        e2 = e5;
                        z = e4;
                        e3 = false;
                    } else if (size >= 3) {
                        boolean e6 = this.f18675d.e(context, list.get(0), a(list.get(0), list2));
                        e2 = this.f18676e.e(context, list.get(1), a(list.get(1), list2));
                        e3 = this.f18677f.e(context, list.get(2), a(list.get(2), list2));
                        z = e6;
                    } else {
                        z = false;
                    }
                    if (z && !e2 && !e3) {
                        this.f18674c.setVisibility(8);
                        return;
                    } else {
                        this.f18674c.setVisibility(0);
                        return;
                    }
                }
                z = this.f18675d.e(context, list.get(0), a(list.get(0), list2));
                this.f18676e.d(false);
                this.f18677f.d(false);
                e3 = false;
                e2 = false;
                if (z) {
                }
                this.f18674c.setVisibility(0);
                return;
            }
            this.f18674c.setVisibility(8);
            this.f18675d.d(false);
            this.f18676e.d(false);
            this.f18677f.d(false);
            this.f18678g.setVisibility(8);
        }
    }
}
