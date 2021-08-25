package c.a.q0.i2.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.q0.i2.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e extends b<CustomDialogData> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public CustomDialogData f19159g;

    /* renamed from: h  reason: collision with root package name */
    public f f19160h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f19161i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19162j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public LinearLayout p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.i2.j.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19161i = (TbImageView) getViewGroup().findViewById(R.id.dialog_image);
            this.f19162j = (TextView) getViewGroup().findViewById(R.id.dialog_title);
            this.k = (TextView) getViewGroup().findViewById(R.id.dialog_body);
            this.l = (TextView) getViewGroup().findViewById(R.id.yes);
            this.m = (TextView) getViewGroup().findViewById(R.id.no);
            this.n = getViewGroup().findViewById(R.id.bdDialog_divider_line);
            this.o = getViewGroup().findViewById(R.id.divider_yes_no_button);
            this.p = (LinearLayout) getViewGroup().findViewById(R.id.real_view);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            SkinManager.setBackgroundResource(this.l, R.drawable.dialog_single_button_bg_selector);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f19162j, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.common_color_10122);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.p, R.drawable.dialog_background);
        }
    }

    @Override // c.a.q0.i2.j.g
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.custom_dailog_view : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.i2.j.g
    /* renamed from: e */
    public void b(CustomDialogData customDialogData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customDialogData) == null) || customDialogData == null) {
            return;
        }
        this.f19159g = customDialogData;
        CustomDialogData.Head head = customDialogData.head;
        if (!TextUtils.isEmpty(head.imageUrl)) {
            this.f19161i.startLoad(head.imageUrl, 10, false);
        }
        if (!TextUtils.isEmpty(head.text)) {
            this.f19162j.setText(head.text);
        }
        if (!TextUtils.isEmpty(customDialogData.body)) {
            this.k.setText(customDialogData.body);
        }
        CustomDialogData.Button button = customDialogData.leftButton;
        if (button != null && !StringUtils.isNull(button.text)) {
            this.m.setText(customDialogData.leftButton.text);
        }
        CustomDialogData.Button button2 = customDialogData.rightButton;
        if (button2 == null || StringUtils.isNull(button2.text)) {
            return;
        }
        this.l.setText(customDialogData.rightButton.text);
    }

    public void f(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f19160h = fVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomDialogData.Button button;
        CustomDialogData.Button button2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.l) {
                CustomDialogData customDialogData = this.f19159g;
                if (customDialogData != null && (button2 = customDialogData.rightButton) != null && !StringUtils.isNull(button2.action)) {
                    UrlManager.getInstance().dealOneLink(d(), new String[]{this.f19159g.rightButton.action});
                }
                f fVar = this.f19160h;
                if (fVar != null) {
                    fVar.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(b.a.f18942b);
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
            } else if (view == this.m) {
                CustomDialogData customDialogData2 = this.f19159g;
                if (customDialogData2 != null && (button = customDialogData2.leftButton) != null && !StringUtils.isNull(button.action)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f19157e.getPageActivity(), null, this.f19159g.leftButton.action, true)));
                }
                f fVar2 = this.f19160h;
                if (fVar2 != null) {
                    fVar2.dismiss();
                }
                StatisticItem statisticItem2 = new StatisticItem(b.a.f18942b);
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
            }
        }
    }
}
