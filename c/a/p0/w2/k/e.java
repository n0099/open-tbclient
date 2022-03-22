package c.a.p0.w2.k;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.p0.w2.b;
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

    /* renamed from: c  reason: collision with root package name */
    public CustomDialogData f19890c;

    /* renamed from: d  reason: collision with root package name */
    public f f19891d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f19892e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19893f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19894g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19895h;
    public TextView i;
    public View j;
    public View k;
    public LinearLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.w2.k.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19892e = (TbImageView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0907a7);
            this.f19893f = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0907b6);
            this.f19894g = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f090793);
            this.f19895h = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0924b7);
            this.i = (TextView) getViewGroup().findViewById(R.id.obfuscated_res_0x7f09157d);
            this.j = getViewGroup().findViewById(R.id.obfuscated_res_0x7f090338);
            this.k = getViewGroup().findViewById(R.id.obfuscated_res_0x7f09080d);
            this.l = (LinearLayout) getViewGroup().findViewById(R.id.obfuscated_res_0x7f0919c9);
            this.f19895h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            SkinManager.setBackgroundResource(this.f19895h, R.drawable.dialog_single_button_bg_selector);
            SkinManager.setViewTextColor(this.f19895h, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f19893f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f19894g, (int) R.color.common_color_10122);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.l, R.drawable.dialog_background);
        }
    }

    @Override // c.a.p0.w2.k.g
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0210 : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.w2.k.g
    /* renamed from: e */
    public void b(CustomDialogData customDialogData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, customDialogData) == null) || customDialogData == null) {
            return;
        }
        this.f19890c = customDialogData;
        CustomDialogData.Head head = customDialogData.head;
        if (!TextUtils.isEmpty(head.imageUrl)) {
            this.f19892e.J(head.imageUrl, 10, false);
        }
        if (!TextUtils.isEmpty(head.text)) {
            this.f19893f.setText(head.text);
        }
        if (!TextUtils.isEmpty(customDialogData.body)) {
            this.f19894g.setText(customDialogData.body);
        }
        CustomDialogData.Button button = customDialogData.leftButton;
        if (button != null && !StringUtils.isNull(button.text)) {
            this.i.setText(customDialogData.leftButton.text);
        }
        CustomDialogData.Button button2 = customDialogData.rightButton;
        if (button2 == null || StringUtils.isNull(button2.text)) {
            return;
        }
        this.f19895h.setText(customDialogData.rightButton.text);
    }

    public void f(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f19891d = fVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomDialogData.Button button;
        CustomDialogData.Button button2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.f19895h) {
                CustomDialogData customDialogData = this.f19890c;
                if (customDialogData != null && (button2 = customDialogData.rightButton) != null && !StringUtils.isNull(button2.action)) {
                    UrlManager.getInstance().dealOneLink(d(), new String[]{this.f19890c.rightButton.action});
                }
                f fVar = this.f19891d;
                if (fVar != null) {
                    fVar.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(b.a.f19731b);
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
            } else if (view == this.i) {
                CustomDialogData customDialogData2 = this.f19890c;
                if (customDialogData2 != null && (button = customDialogData2.leftButton) != null && !StringUtils.isNull(button.action)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageActivity(), null, this.f19890c.leftButton.action, true)));
                }
                f fVar2 = this.f19891d;
                if (fVar2 != null) {
                    fVar2.dismiss();
                }
                StatisticItem statisticItem2 = new StatisticItem(b.a.f19731b);
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
            }
        }
    }
}
