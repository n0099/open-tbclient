package b.a.r0.k2.q.d;

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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f20238a;

    /* renamed from: b  reason: collision with root package name */
    public View f20239b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20240c;

    /* renamed from: d  reason: collision with root package name */
    public b f20241d;

    /* renamed from: e  reason: collision with root package name */
    public b f20242e;

    /* renamed from: f  reason: collision with root package name */
    public b f20243f;

    /* renamed from: g  reason: collision with root package name */
    public View f20244g;

    /* loaded from: classes5.dex */
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
        this.f20239b = inflate;
        this.f20240c = (TextView) inflate.findViewById(R.id.chosen_pb_comment_title);
        this.f20244g = this.f20239b.findViewById(R.id.chosen_pb_comment_line);
        this.f20238a = this.f20239b.findViewById(R.id.comment_layout_blank_view);
        this.f20241d = new b((ViewStub) this.f20239b.findViewById(R.id.chosen_pb_commrnt_first), aVar);
        this.f20242e = new b((ViewStub) this.f20239b.findViewById(R.id.chosen_pb_commrnt_second), aVar);
        this.f20243f = new b((ViewStub) this.f20239b.findViewById(R.id.chosen_pb_commrnt_third), aVar);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20239b : (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.f20239b, R.color.common_color_10187);
            SkinManager.setBackgroundColor(this.f20238a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f20240c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f20244g, R.color.CAM_X0204);
            this.f20241d.c();
            this.f20242e.c();
            this.f20243f.c();
        }
    }

    public void d(Context context, List<Post> list, List<User> list2) {
        boolean z;
        boolean update;
        boolean update2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                this.f20244g.setVisibility(0);
                int size = list.size();
                if (size != 1) {
                    if (size == 2) {
                        boolean update3 = this.f20241d.update(context, list.get(0), a(list.get(0), list2));
                        boolean update4 = this.f20242e.update(context, list.get(1), a(list.get(1), list2));
                        this.f20243f.d(false);
                        update = update4;
                        z = update3;
                        update2 = false;
                    } else if (size >= 3) {
                        boolean update5 = this.f20241d.update(context, list.get(0), a(list.get(0), list2));
                        update = this.f20242e.update(context, list.get(1), a(list.get(1), list2));
                        update2 = this.f20243f.update(context, list.get(2), a(list.get(2), list2));
                        z = update5;
                    } else {
                        z = false;
                    }
                    if (z && !update && !update2) {
                        this.f20240c.setVisibility(8);
                        return;
                    } else {
                        this.f20240c.setVisibility(0);
                        return;
                    }
                }
                z = this.f20241d.update(context, list.get(0), a(list.get(0), list2));
                this.f20242e.d(false);
                this.f20243f.d(false);
                update2 = false;
                update = false;
                if (z) {
                }
                this.f20240c.setVisibility(0);
                return;
            }
            this.f20240c.setVisibility(8);
            this.f20241d.d(false);
            this.f20242e.d(false);
            this.f20243f.d(false);
            this.f20244g.setVisibility(8);
        }
    }
}
