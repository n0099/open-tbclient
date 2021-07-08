package com.baidu.tbadk.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
import tbclient.Item;
/* loaded from: classes3.dex */
public class ItemData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double mIconSize;
    public String mIconUrl;
    public double mScore;
    public int mStar;
    public List<String> mTags;
    public String mTitle;

    public ItemData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void parseItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbRichTextEvaluateItemInfo) == null) || tbRichTextEvaluateItemInfo == null) {
            return;
        }
        this.mIconUrl = tbRichTextEvaluateItemInfo.getIconUrl();
        this.mTitle = tbRichTextEvaluateItemInfo.getTitle();
        this.mTags = tbRichTextEvaluateItemInfo.getTags();
        this.mScore = tbRichTextEvaluateItemInfo.getScore();
        this.mStar = tbRichTextEvaluateItemInfo.getStar();
        this.mIconSize = tbRichTextEvaluateItemInfo.getIconSize();
    }

    public void parseProto(Item item) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) || item == null) {
            return;
        }
        this.mIconUrl = item.icon_url;
        this.mTitle = item.item_name;
        this.mTags = item.tags;
        this.mScore = item.score.doubleValue();
        this.mStar = item.star.intValue();
        this.mIconSize = item.icon_size.doubleValue();
    }
}
