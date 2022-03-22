package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.widget.richText.TbRichTextEmotionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextEmotionInfo bigEmotion;
    public String bubbleUrl;
    public int height;
    public String imgUrl;
    public int width;

    public ImageInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getTagForView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbRichTextEmotionInfo tbRichTextEmotionInfo = this.bigEmotion;
            if (tbRichTextEmotionInfo != null) {
                return tbRichTextEmotionInfo.mGifInfo.mSharpText;
            }
            String str = this.bubbleUrl;
            return str != null ? str : this.imgUrl;
        }
        return (String) invokeV.objValue;
    }
}
