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
            getIntent().putExtra("key_input_picture_path", bVar.gaS);
            getIntent().putExtra("key_sticker_path", bVar.gaV);
            getIntent().putExtra("key_input_video_path", bVar.gaT);
            getIntent().putExtra("key_output_video_path", bVar.gaU);
            getIntent().putExtra("key_need_mute", bVar.gaQ);
            getIntent().putExtra("key_need_publish", bVar.gaW);
            getIntent().putExtra("key_story_state", bVar.state);
            getIntent().putExtra("key_need_composite", bVar.gaY);
            getIntent().putExtra("key_page_from", bVar.fWe);
            getIntent().putExtra("key_forum_name", bVar.forumName);
            getIntent().putExtra("key_forum_id", bVar.forumId);
        }
    }
}
