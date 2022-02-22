package c.a.u0.u2.q.d;

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
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f23127b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23128c;

    /* renamed from: d  reason: collision with root package name */
    public b f23129d;

    /* renamed from: e  reason: collision with root package name */
    public b f23130e;

    /* renamed from: f  reason: collision with root package name */
    public b f23131f;

    /* renamed from: g  reason: collision with root package name */
    public View f23132g;

    /* loaded from: classes9.dex */
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
        this.f23127b = inflate;
        this.f23128c = (TextView) inflate.findViewById(R.id.chosen_pb_comment_title);
        this.f23132g = this.f23127b.findViewById(R.id.chosen_pb_comment_line);
        this.a = this.f23127b.findViewById(R.id.comment_layout_blank_view);
        this.f23129d = new b((ViewStub) this.f23127b.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.f23130e = new b((ViewStub) this.f23127b.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.f23131f = new b((ViewStub) this.f23127b.findViewById(R.id.chosen_pb_commrnt_third), aVar);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23127b : (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.f23127b, R.color.common_color_10187);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f23128c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f23132g, R.color.CAM_X0204);
            this.f23129d.c();
            this.f23130e.c();
            this.f23131f.c();
        }
    }

    public void d(List<Post> list, List<User> list2) {
        boolean z;
        boolean update;
        boolean update2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                this.f23132g.setVisibility(0);
                int size = list.size();
                if (size != 1) {
                    if (size == 2) {
                        boolean update3 = this.f23129d.update(list.get(0), a(list.get(0), list2));
                        boolean update4 = this.f23130e.update(list.get(1), a(list.get(1), list2));
                        this.f23131f.d(false);
                        update = update4;
                        z = update3;
                        update2 = false;
                    } else if (size >= 3) {
                        boolean update5 = this.f23129d.update(list.get(0), a(list.get(0), list2));
                        update = this.f23130e.update(list.get(1), a(list.get(1), list2));
                        update2 = this.f23131f.update(list.get(2), a(list.get(2), list2));
                        z = update5;
                    } else {
                        z = false;
                    }
                    if (z && !update && !update2) {
                        this.f23128c.setVisibility(8);
                        return;
                    } else {
                        this.f23128c.setVisibility(0);
                        return;
                    }
                }
                z = this.f23129d.update(list.get(0), a(list.get(0), list2));
                this.f23130e.d(false);
                this.f23131f.d(false);
                update2 = false;
                update = false;
                if (z) {
                }
                this.f23128c.setVisibility(0);
                return;
            }
            this.f23128c.setVisibility(8);
            this.f23129d.d(false);
            this.f23130e.d(false);
            this.f23131f.d(false);
            this.f23132g.setVisibility(8);
        }
    }
}
