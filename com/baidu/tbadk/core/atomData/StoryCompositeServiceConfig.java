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
            getIntent().putExtra("key_input_picture_path", bVar.gdA);
            getIntent().putExtra("key_sticker_path", bVar.gdD);
            getIntent().putExtra("key_input_video_path", bVar.gdB);
            getIntent().putExtra("key_output_video_path", bVar.gdC);
            getIntent().putExtra("key_need_mute", bVar.gdy);
            getIntent().putExtra("key_need_publish", bVar.gdE);
            getIntent().putExtra("key_story_state", bVar.state);
            getIntent().putExtra("key_need_composite", bVar.gdG);
            getIntent().putExtra("key_page_from", bVar.fYH);
            getIntent().putExtra("key_forum_name", bVar.forumName);
            getIntent().putExtra("key_forum_id", bVar.forumId);
        }
    }
}
