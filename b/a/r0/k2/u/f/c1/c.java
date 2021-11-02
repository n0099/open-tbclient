package b.a.r0.k2.u.f.c1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.q0.s.q.d2;
import b.a.r0.k2.r.f;
import b.a.r0.k2.r.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19165a;

    /* renamed from: b  reason: collision with root package name */
    public b f19166b;

    /* loaded from: classes5.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19167a;

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
            this.f19167a = cVar;
        }

        @Override // b.a.r0.k2.u.f.c1.c.b
        public void a(f fVar, d2 d2Var, PostData postData, b.a.q0.f1.n.a aVar) {
            String e2;
            String s1;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, fVar, d2Var, postData, aVar) == null) {
                if ((fVar == null && d2Var == null) || postData == null || this.f19167a.f19165a == null) {
                    return;
                }
                if (fVar == null) {
                    e2 = this.f19167a.e(d2Var);
                } else {
                    String str2 = fVar.N(this.f19167a.f19165a.getPageActivity(), false)[0];
                    if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str2 = str2.substring(37);
                    }
                    d2 O = fVar.O();
                    if (O == null) {
                        return;
                    }
                    String str3 = str2;
                    d2Var = O;
                    e2 = str3;
                }
                n nVar = new n();
                nVar.h(d2Var.o());
                if (!StringUtils.isNull(e2)) {
                    nVar.k(e2);
                }
                nVar.l(d2Var.o1());
                nVar.g(aVar);
                nVar.i(postData);
                String title = d2Var.getTitle();
                if (StringUtils.isNull(title)) {
                    title = d2Var.o();
                }
                nVar.h(title);
                if (d2Var.D2()) {
                    s1 = d2Var.L().oriUgcTid;
                    str = "?share=9105&fr=dshare&dtype=" + d2Var.L().oriUgcType + "&dvid=" + d2Var.L().oriUgcVid + "&nid=" + d2Var.L().oriUgcNid;
                } else {
                    s1 = d2Var.s1();
                    str = "?share=9105&fr=share";
                }
                nVar.j(this.f19167a.d("http://tieba.baidu.com/p/" + s1 + (str + "&post_id=" + postData.G() + "&share_from=comment&post_sort=1")));
                ShareItem shareItem = new ShareItem();
                shareItem.Z = 1;
                shareItem.k = true;
                shareItem.q = s1;
                shareItem.V = postData.G();
                Bundle bundle = new Bundle();
                bundle.putString("tid", s1);
                bundle.putString("pid", postData.G());
                bundle.putInt("source", 1);
                shareItem.k(bundle);
                PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.f19167a.f19165a.getPageActivity(), shareItem, true, nVar);
                pbPostShareDialogConfig.setIsCopyLink(false);
                pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                this.f19167a.f19165a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem.param("tid", s1);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (d2Var.Y() != null) {
                    statisticItem.param("fid", d2Var.Y().f13505a);
                }
                if (d2Var.v1() != null) {
                    statisticItem.param("post_id", postData.G());
                }
                statisticItem.param("obj_locate", 21);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(f fVar, d2 d2Var, PostData postData, b.a.q0.f1.n.a aVar);
    }

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19166b = new a(this);
        this.f19165a = tbPageContext;
    }

    public final Bitmap d(String str) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
                return null;
            }
            return (Bitmap) runTask.getData();
        }
        return (Bitmap) invokeL.objValue;
    }

    public final String e(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            String str = null;
            if (d2Var == null) {
                return null;
            }
            if (d2Var.l1() != null && !TextUtils.isEmpty(d2Var.l1().cover)) {
                return d2Var.l1().cover;
            }
            if (d2Var.E0() == null) {
                return null;
            }
            ArrayList<MediaData> E0 = d2Var.E0();
            int size = E0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = E0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i2++;
            }
            return (str != null || d2Var.q1() == null || TextUtils.isEmpty(d2Var.q1().thumbnail_url)) ? str : d2Var.q1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }
}
