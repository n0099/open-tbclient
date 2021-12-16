package c.a.s0.d1.c2;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f15736b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15737c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15738d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f15739e;

    /* renamed from: f  reason: collision with root package name */
    public EntelechyUserLikeButton f15740f;

    /* renamed from: g  reason: collision with root package name */
    public View f15741g;

    /* renamed from: h  reason: collision with root package name */
    public int f15742h;

    /* renamed from: i  reason: collision with root package name */
    public int f15743i;

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15743i = 3;
        this.a = view;
        this.f15736b = (BarImageView) view.findViewById(R.id.frs_feed_forum_image);
        this.f15737c = (TextView) view.findViewById(R.id.frs_feed_forum_title);
        this.f15738d = (TextView) view.findViewById(R.id.frs_feed_forum_other_info);
        this.f15739e = (TextView) view.findViewById(R.id.frs_feed_forum_related);
        this.f15740f = (EntelechyUserLikeButton) view.findViewById(R.id.frs_feed_forum_attention);
        this.f15741g = view.findViewById(R.id.frs_feed_forum_divider);
    }
}
