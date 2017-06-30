package com.baidu.tbadk.core.view;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    private final /* synthetic */ int acD;
    final /* synthetic */ ThreadGodReplyLayout and;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ThreadGodReplyLayout threadGodReplyLayout, int i) {
        this.and = threadGodReplyLayout;
        this.acD = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List<TbRichTextImageInfo> list3;
        list = this.and.mImageList;
        if (list != null) {
            list2 = this.and.mImageList;
            if (list2.size() != 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                list3 = this.and.mImageList;
                for (TbRichTextImageInfo tbRichTextImageInfo : list3) {
                    arrayList.add(tbRichTextImageInfo.Im());
                }
                ImageViewerConfig createConfig = new ImageViewerConfig(this.and.getContext()).createConfig(arrayList, this.acD, null, "", "", true, arrayList.get(0), true);
                createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            }
        }
    }
}
