package c.a.r0.j1.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.HotTopicDetailView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f19423a;

    /* renamed from: b  reason: collision with root package name */
    public View f19424b;

    /* renamed from: c  reason: collision with root package name */
    public String f19425c;

    /* renamed from: d  reason: collision with root package name */
    public String f19426d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19427e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19427e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.e2.c.g(this.f19427e.f19423a, "c14391");
                this.f19427e.c();
            }
        }
    }

    public c(View view, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19423a = tbPageContext;
        this.f19424b = view;
        if (view instanceof TextView) {
            HotTopicDetailView.setWriteViewStyle((TextView) view, SkinManager.getColor(R.color.CAM_X0302));
        }
        this.f19424b.setOnClickListener(new a(this));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || WriteActivityConfig.isAsyncWriting() || this.f19425c == null) {
            return;
        }
        String format = StringUtils.isNull(this.f19426d) ? null : String.format(TbadkCoreApplication.getInst().getString(R.string.hot_topic_detail_write_name), this.f19426d);
        WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f19423a.getPageActivity());
        newInstance.setIntentAction(IntentAction.ActivityForResult);
        newInstance.setRequestCode(25065);
        newInstance.setType(9).setForumId("0").setTopicId(String.valueOf(this.f19425c)).setFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL).setCallFrom("1").setTitle(format).send();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f19426d = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f19425c = str;
        }
    }
}
