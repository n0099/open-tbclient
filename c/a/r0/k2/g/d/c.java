package c.a.r0.k2.g.d;

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
    public View f19746a;

    /* renamed from: b  reason: collision with root package name */
    public View f19747b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19748c;

    /* renamed from: d  reason: collision with root package name */
    public b f19749d;

    /* renamed from: e  reason: collision with root package name */
    public b f19750e;

    /* renamed from: f  reason: collision with root package name */
    public b f19751f;

    /* renamed from: g  reason: collision with root package name */
    public View f19752g;

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
        this.f19747b = inflate;
        this.f19748c = (TextView) inflate.findViewById(R.id.chosen_pb_comment_title);
        this.f19752g = this.f19747b.findViewById(R.id.chosen_pb_comment_line);
        this.f19746a = this.f19747b.findViewById(R.id.comment_layout_blank_view);
        this.f19749d = new b((ViewStub) this.f19747b.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.f19750e = new b((ViewStub) this.f19747b.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.f19751f = new b((ViewStub) this.f19747b.findViewById(R.id.chosen_pb_commrnt_third), aVar);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19747b : (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.f19747b, R.color.common_color_10187);
            SkinManager.setBackgroundColor(this.f19746a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f19748c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f19752g, R.color.CAM_X0204);
            this.f19749d.c();
            this.f19750e.c();
            this.f19751f.c();
        }
    }

    public void d(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean e2;
        boolean e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                this.f19752g.setVisibility(0);
                int size = list.size();
                if (size != 1) {
                    if (size == 2) {
                        boolean e4 = this.f19749d.e(context, list.get(0), a(list.get(0), list2));
                        boolean e5 = this.f19750e.e(context, list.get(1), a(list.get(1), list2));
                        this.f19751f.d(false);
                        e2 = e5;
                        z = e4;
                        e3 = false;
                    } else if (size >= 3) {
                        boolean e6 = this.f19749d.e(context, list.get(0), a(list.get(0), list2));
                        e2 = this.f19750e.e(context, list.get(1), a(list.get(1), list2));
                        e3 = this.f19751f.e(context, list.get(2), a(list.get(2), list2));
                        z = e6;
                    } else {
                        z = false;
                    }
                    if (z && !e2 && !e3) {
                        this.f19748c.setVisibility(8);
                        return;
                    } else {
                        this.f19748c.setVisibility(0);
                        return;
                    }
                }
                z = this.f19749d.e(context, list.get(0), a(list.get(0), list2));
                this.f19750e.d(false);
                this.f19751f.d(false);
                e3 = false;
                e2 = false;
                if (z) {
                }
                this.f19748c.setVisibility(0);
                return;
            }
            this.f19748c.setVisibility(8);
            this.f19749d.d(false);
            this.f19750e.d(false);
            this.f19751f.d(false);
            this.f19752g.setVisibility(8);
        }
    }
}
