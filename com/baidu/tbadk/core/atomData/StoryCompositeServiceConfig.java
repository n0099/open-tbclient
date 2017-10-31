package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.story.process.b;
/* loaded from: classes.dex */
public class StoryCompositeServiceConfig extends IntentConfig {
    public StoryCompositeServiceConfig(Context context, b bVar) {
        super(context);
        setIntentAction(IntentAction.StartService);
        if (bVar != null) {
            getIntent().putExtra("key_input_type", bVar.type);
            getIntent().putExtra("key_input_picture_path", bVar.gjF);
            getIntent().putExtra("key_sticker_path", bVar.gjI);
            getIntent().putExtra("key_input_video_path", bVar.gjG);
            getIntent().putExtra("key_output_video_path", bVar.gjH);
            getIntent().putExtra("key_need_mute", bVar.gjD);
            getIntent().putExtra("key_need_publish", bVar.gjJ);
            getIntent().putExtra("key_story_state", bVar.state);
            getIntent().putExtra("key_need_composite", bVar.gjL);
            getIntent().putExtra("key_page_from", bVar.geK);
            getIntent().putExtra("key_forum_name", bVar.forumName);
            getIntent().putExtra("key_forum_id", bVar.forumId);
        }
    }
}
